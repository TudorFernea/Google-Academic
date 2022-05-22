package com.example.demo.Controllers;

import com.example.demo.DTOs.AddOptionalDTO;
import com.example.demo.DTOs.CurriculumDTO;
import com.example.demo.DTOs.DisciplineDTO;
import com.example.demo.DTOs.YearOfStudyDTO;
import com.example.demo.Models.*;
import com.example.demo.Services.CurriculumService;
import com.example.demo.Services.DisciplineService;
import com.example.demo.Services.TeacherService;
import com.example.demo.Services.YearOfStudyService;
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
    private final YearOfStudyService yearOfStudyService;
    private final TeacherService teacherService;
    private final CurriculumService curriculumService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService, YearOfStudyService yearOfStudyService, TeacherService teacherService, CurriculumService curriculumService) {
        this.disciplineService = disciplineService;
        this.yearOfStudyService = yearOfStudyService;
        this.teacherService = teacherService;
        this.curriculumService = curriculumService;
    }

    @GetMapping
    public List<Discipline> getAllDiscipline(){
        return disciplineService.getAllDiscipline();
    }

    @PostMapping("/add")
    public void addDiscipline(@RequestBody Discipline discipline) {
        disciplineService.addDiscipline(discipline);
    }

    @PostMapping("/addOptional")
    public boolean addDiscipline(@RequestBody AddOptionalDTO addOptionalDTO) {
        Curriculum curriculum = new Curriculum(addOptionalDTO.getDescription());
        curriculumService.addCurriculum(curriculum);
        Teacher teacher = teacherService.findTeacherByUsername(addOptionalDTO.getUsername());
        Discipline discipline = new Discipline(addOptionalDTO.getName(), true,addOptionalDTO.getNrcredit(), curriculum, teacher);
        disciplineService.addDiscipline(discipline);
        return true;
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

    @PostMapping("/getMandatoryByYear")
    public List<DisciplineDTO> getDisciplineByYearOfStudy(@RequestBody YearOfStudyDTO yearOfStudyDTO)
    {
        YearOfStudy yearOfStudy = yearOfStudyService.findYearOfStudy(yearOfStudyDTO.getId()).get();

        return disciplineService.getDisciplineByYearOfStudy(yearOfStudy)
                .stream()
                .filter(discipline -> !discipline.getOptional())
                .map(discipline -> new DisciplineDTO(
                        discipline.getId(),
                        discipline.getName(),
                        discipline.getOptional(),
                        discipline.getNoOfCredits(),
                        new CurriculumDTO(discipline.getCurriculum().getId(),discipline.getCurriculum().getText())
                )).collect(Collectors.toList());
    }

    @PostMapping("/getOptionalByYear")
    public List<DisciplineDTO> getOptionalDisciplineByYearOfStudy(@RequestBody YearOfStudyDTO yearOfStudyDTO)
    {
        YearOfStudy yearOfStudy = yearOfStudyService.findYearOfStudy(yearOfStudyDTO.getId()).get();

        return disciplineService.getDisciplineByYearOfStudy(yearOfStudy)
                .stream()
                .filter(discipline -> discipline.getOptional())
                .map(discipline -> new DisciplineDTO(
                        discipline.getId(),
                        discipline.getName(),
                        discipline.getOptional(),
                        discipline.getNoOfCredits(),
                        new CurriculumDTO(discipline.getCurriculum().getId(),discipline.getCurriculum().getText())
                )).collect(Collectors.toList());
    }
}
