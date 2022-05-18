package com.example.demo.Controllers;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Teacher;
import com.example.demo.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("TeacherController")
@RequestMapping(value="api/teachers")
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

    @PostMapping("/verifyTeacherDiscipline")
    public Boolean isTeacherOfDiscipline(@RequestBody Teacher teacher, Discipline discipline)
    {
        return this.teacherService.isTeacherOfDiscipline(teacher, discipline);
    }

}
