package com.example.demo.Controllers;

import com.example.demo.DTOs.CurriculumDTO;
import com.example.demo.DTOs.DisciplineDTO;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Teacher;
import com.example.demo.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
