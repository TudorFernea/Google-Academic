package com.example.demo.Controllers;

import com.example.demo.DTOs.CurriculumDTO;
import com.example.demo.DTOs.DisciplineDTO;
import com.example.demo.DTOs.TeacherDTO;
import com.example.demo.DTOs.YearOfStudyDTO;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Faculty;
import com.example.demo.Models.Teacher;
import com.example.demo.Models.YearOfStudy;
import com.example.demo.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("TeacherController")
@RequestMapping(value="api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @PostMapping("/add")
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
    }

    @PostMapping("/get/{username}")
    public Integer getTeacher(@PathVariable String username){
        return teacherService.findTeacherByUsername(username).getId();
    }

    @GetMapping("/getAllByFaculty/{username}")
    public List<TeacherDTO> getAllByFaculty(@PathVariable String username){
        Teacher teacher = teacherService.findTeacherByUsername(username);
        Faculty faculty = teacher.getTeacherFaculty();
        return faculty.getTeacherList().stream()
                .map(teacher1 -> new TeacherDTO(
                        teacher1.getId(),
                        teacher1.getFirstName(),
                        teacher1.getLastName()
                )).collect(Collectors.toList());
    }

    @GetMapping("/getAllYearOfStudy/{username}")
    public List<YearOfStudyDTO> getAllYearOfStudy(@PathVariable String username){

        Teacher teacher = teacherService.findTeacherByUsername(username);
        Faculty faculty = teacher.getTeacherFaculty();
        List<YearOfStudy> yearOfStudyList = new ArrayList<>();

        faculty.getSpecializationList().stream()
                .forEach(specialization -> yearOfStudyList.addAll(specialization.getYearOfStudyList()));

        return yearOfStudyList.stream()
                .map(yearOfStudy -> new YearOfStudyDTO(
                        yearOfStudy.getId(),
                        yearOfStudy.getYear(),
                        yearOfStudy.getSpecialization().getName()
                )).collect(Collectors.toList());

    }

    @PostMapping("/getAllDiscipline/{username}")
    public List<DisciplineDTO> getAllDiscipline(@PathVariable String username){
        Teacher teacher = teacherService.findTeacherByUsername(username);
        return teacher.getDisciplineList().stream()
                .map(discipline -> new DisciplineDTO(
                        discipline.getId(),
                        discipline.getName(),
                        discipline.getOptional(),
                        discipline.getNoOfCredits(),
                        new CurriculumDTO(discipline.getCurriculum().getId(),discipline.getCurriculum().getText())
                )).collect(Collectors.toList());
    }

    @PostMapping("/verifyTeacherDiscipline")
    public Boolean isTeacherOfDiscipline(@RequestBody Teacher teacher, Discipline discipline)
    {
        return this.teacherService.isTeacherOfDiscipline(teacher, discipline);
    }



}
