package com.example.demo.Controllers;

import com.example.demo.DTOs.GradeDTO;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Grade;
import com.example.demo.Models.Student;
import com.example.demo.Services.DisciplineService;
import com.example.demo.Services.GradeService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController("GradeController")
@RequestMapping(value="api/grade")
public class GradeController {
    private final GradeService gradeService;
    private final StudentService studentService;
    private final DisciplineService disciplineService;


    @Autowired
    public GradeController(GradeService gradeService, StudentService studentService, DisciplineService disciplineService) {
        this.gradeService = gradeService;
        this.studentService = studentService;
        this.disciplineService = disciplineService;
    }

    @GetMapping(value="/bystudent") // view grades
    public List<Grade> getGradesByStudent(@RequestBody Student student){ //gradedto cu grade si discipline grade
        return gradeService.getGradesByStudent(student);
    }

    @PostMapping("/add")
    public boolean addGrade(@RequestBody GradeDTO gradeDTO) {

        Student student = studentService.findStudent(gradeDTO.getStudentId());
        Discipline discipline = disciplineService.getDiscipline(gradeDTO.getDisciplineId());
        Grade grade = new Grade(student, discipline, Integer.parseInt(gradeDTO.getGrade()));

        gradeService.addGrade(grade);
        return true;
    }

    @GetMapping(value="/professionalresults")
    public void getProfessionalResults() {
        gradeService.getProfessionalResults();
        System.out.println("Service function was called");
    }
}
