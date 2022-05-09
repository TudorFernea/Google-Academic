package com.example.demo.Controllers;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Grade;
import com.example.demo.Models.Student;
import com.example.demo.Services.DisciplineService;
import com.example.demo.Services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("GradeController")
@RequestMapping(path="api/grades")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping(value="/bystudent")
    public List<Grade> getGradesByStudent(@RequestBody Student student){
        return gradeService.getGradesByStudent(student);
    }

    @PostMapping
    public void addGrade(@RequestBody Grade grade) {
        gradeService.addGrade(grade);
    }
}