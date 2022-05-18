package com.example.demo.Controllers;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Grade;
import com.example.demo.Models.Student;
import com.example.demo.Services.DisciplineService;
import com.example.demo.Services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController("GradeController")
@RequestMapping(value="api/grades")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping(value="/bystudent") // view grades
    public List<Grade> getGradesByStudent(@RequestBody Student student){
        return gradeService.getGradesByStudent(student);
    }

    @PostMapping
    public void addGrade(@RequestBody Grade grade) {
        gradeService.addGrade(grade);
    }

    @GetMapping(value="/professionalresults")
    public void getProfessionalResults() {
        gradeService.getProfessionalResults();
        System.out.println("Service function was called");
    }
}
