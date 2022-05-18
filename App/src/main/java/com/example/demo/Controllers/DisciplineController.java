package com.example.demo.Controllers;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import com.example.demo.Models.Teacher;
import com.example.demo.Models.YearOfStudy;
import com.example.demo.Services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@CrossOrigin(origins = "http://localhost:4200")
@RestController("DisciplineController")
@RequestMapping(value="api/discipline")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public List<Discipline> getDisciplines(){
        return disciplineService.getDisciplines();
    }

    @PostMapping("/add")
    public void addDiscipline(@RequestBody Discipline discipline) {
        disciplineService.addDiscipline(discipline);
    }

    /*@PostMapping("/optionals")
    public List<Discipline> getOptionalsByStudent(@RequestBody Student student){
        List<Discipline> list1 = disciplineService.getDisciplinesByCurriculum(student.getYearOfStudy1().getCurriculum());// validari, daca nu e yearofstudy?
        List<Discipline> list2 = disciplineService.getDisciplinesByCurriculum(student.getYearOfStudy2().getCurriculum());
        List<Discipline> resultList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        return resultList;
    }*/

    @GetMapping("/bestresults")
    public Discipline getDisciplineWithBestResults(){
        return disciplineService.getDisciplineWithBestResults();
    }

    @PostMapping("/maxstudents/{nr}")
    public void setMaxStudents(@RequestBody Discipline discipline, @PathVariable Integer nr) throws Exception {
        if(discipline.getOptional())
        {
            discipline.setMaxNoOfStudents(nr);
        }
        else{
            throw new Exception("Discipline is not an optional!");
        }
    }

    @PostMapping("/disciplinebyteacher")
    public List<Discipline> getDisciplineByTeacher(@RequestBody Teacher teacher){
        return disciplineService.getDisciplineByTeacher(teacher);
    }

    @PostMapping("/disciplinesByTeacherAndYearOfStudy")
    public List<Discipline> getDisciplineByTeacherAndYearOfStudy(@RequestBody Teacher teacher, YearOfStudy yearOfStudy)
    {
        return disciplineService.getDisciplineByYearOfStudyAndTeacher(yearOfStudy, teacher);
    }
}
