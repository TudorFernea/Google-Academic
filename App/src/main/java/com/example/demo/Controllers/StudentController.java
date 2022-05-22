package com.example.demo.Controllers;

import com.example.demo.DTOs.YearOfStudyDTO;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import com.example.demo.Models.YearOfStudy;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("StudentController")
@RequestMapping(value="api/student")
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

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PostMapping("/enrol/{username}")
    public String enrolStudent(@RequestBody YearOfStudy yearOfStudy, @PathVariable String username){

        Student student = studentService.findByUsername(username);

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

    @GetMapping("/getAllYearOfStudy/{username}")
    public List<YearOfStudyDTO> getAllYearOfStudy(@PathVariable String username){

        Student student = studentService.findByUsername(username);

        return List.of(student.getYearOfStudy1(),student.getYearOfStudy2())
                .stream()
                .map(year -> new YearOfStudyDTO(
                        year.getId(),
                        year.getYear(),
                        year.getSpecialization().getName()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/studentsByDiscipline")
    public List<Student> getStudentsByDiscipline(@RequestBody Discipline discipline)
    {
        return studentService.getStudentsByDiscipline(discipline);
    }
}

