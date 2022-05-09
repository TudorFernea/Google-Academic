package com.example.demo.Controllers;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import com.example.demo.Models.YearOfStudy;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@RestController("StudentController")
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PostMapping
    public String enrollStudent(@RequestBody Student student, YearOfStudy yearOfStudy){
        //Optional<Student> result_student = studentService.findStudent(student);
        //Optional<YearOfStudy> result_year = ??
        //Student student1 = result_student.get();

        if(student.getYearOfStudy1() == null)
        {
            student.setYearOfStudy1(yearOfStudy);
            studentService.addStudent(student);
        }
        else
            if(student.getYearOfStudy2() == null)
            {
                student.setYearOfStudy2(yearOfStudy);
                studentService.addStudent(student);
            }
            else
                return "401";

        return "200";
    }
}

