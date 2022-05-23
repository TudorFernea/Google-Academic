package com.example.demo.Controllers;

import com.example.demo.DTOs.AssignDTO;
import com.example.demo.DTOs.DisciplineDTO;
import com.example.demo.Models.Choice;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import com.example.demo.Services.ChoiceService;
import com.example.demo.Services.DisciplineService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("ChoiceController")
@RequestMapping(value="api/choice")
public class ChoiceController {

    private final ChoiceService choiceService;
    private final StudentService studentService;
    private final DisciplineService disciplineService;

    @Autowired
    public ChoiceController(ChoiceService choiceService, StudentService studentService, DisciplineService disciplineService) {
        this.choiceService = choiceService;
        this.studentService = studentService;
        this.disciplineService = disciplineService;
    }

    @PostMapping("/update/{username}")
    public boolean chooseOptional(@PathVariable String username, @RequestBody List<DisciplineDTO> list){

        Student student = studentService.findByUsername(username);

        List<Discipline> disciplineList = new ArrayList<Discipline>();
        list.stream()
                        .forEach(disciplineDTO -> disciplineList.add(disciplineService.getDiscipline(disciplineDTO.getId())));

        List<Choice> deletedChoices = choiceService.getChoicesByStudent(student);
        choiceService.deleteAllByList(deletedChoices);

        for(int i=0; i<disciplineList.size(); i++)
        {
            Choice choice = new Choice(student, disciplineList.get(i), i);
            choiceService.addChoice(choice);
        }

        return true;
    }

    @PostMapping("/assign")
    public boolean assignOptionals(@RequestBody List<AssignDTO> list){

        List<Discipline> disciplineList = new ArrayList<>();
        list.stream()
                .forEach(assignDTO -> {
                    Discipline discipline = disciplineService.getDiscipline(assignDTO.getId());
                    discipline.setMaxNoOfStudents(assignDTO.getNoStudents());
                    disciplineList.add(discipline);
                });

        List<Discipline> deletedOptionals = new ArrayList<>();
        List<Discipline> addedOptionals = new ArrayList<>();
        disciplineList.stream()
                .forEach(discipline -> {
                    if(choiceService.getChoicesByDiscipline(discipline)
                                    .stream()
                                    .filter(choice -> choice.getOrder() == 0)
                                    .count() < 1)
                        deletedOptionals.add(discipline);
                    else
                        addedOptionals.add(discipline);
                        }
                );

        disciplineService.deleteAll(deletedOptionals);
        addedOptionals.stream()
                .forEach(discipline -> disciplineService.addDiscipline(discipline));

        List<Choice> badChoices = new ArrayList<>();

        addedOptionals.stream()
                .forEach(
                        discipline -> {
                            int number = discipline.getMaxNoOfStudents();
                            List<Choice> choiceList = choiceService.getChoicesByDiscipline(discipline);
                            choiceList.sort(Comparator.comparing(Choice::getOrder));
                            choiceList.stream()
                                    .forEach(choice -> {
                                        if(discipline.getMaxNoOfStudents()>0)
                                        {
                                            choice.setVerified(true);
                                            discipline.setMaxNoOfStudents(discipline.getMaxNoOfStudents()-1);
                                            choiceService.addChoice(choice);
                                        }
                                        else{
                                            badChoices.add(choice);
                                        }
                                    });

                            discipline.setMaxNoOfStudents(number);
                        }
                );
        if(badChoices.size()>0)
        choiceService.deleteAllByList(badChoices);

        return true;
    }
}
