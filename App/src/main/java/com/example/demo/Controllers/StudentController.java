package com.example.demo.Controllers;

import com.example.demo.DTOs.CurriculumDTO;
import com.example.demo.DTOs.DisciplineDTO;
import com.example.demo.DTOs.StudentDTO;
import com.example.demo.DTOs.YearOfStudyDTO;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import com.example.demo.Models.YearOfStudy;
import com.example.demo.Services.DisciplineService;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("StudentController")
@RequestMapping(value="api/student")
public class StudentController {

    private final StudentService studentService;
    private final DisciplineService disciplineService;

    @Autowired
    public StudentController(StudentService studentService, DisciplineService disciplineService) {
        this.studentService = studentService;
        this.disciplineService = disciplineService;
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

        YearOfStudy yearOfStudy1 = student.getYearOfStudy1();
        YearOfStudy yearOfStudy2 = student.getYearOfStudy2();

        List<YearOfStudy> list = new ArrayList<YearOfStudy>();

        if(yearOfStudy1 != null)
            list.add(yearOfStudy1);
        if(yearOfStudy2 != null)
            list.add(yearOfStudy2);
        
        return list
                .stream()
                .map(year -> new YearOfStudyDTO(
                        year.getId(),
                        year.getYear(),
                        year.getSpecialization().getName()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/studentsByDiscipline/{disciplineId}")
    public List<StudentDTO> getStudentsByDiscipline(@PathVariable Integer disciplineId)
    {
        Discipline discipline = this.disciplineService.getDiscipline(disciplineId);
        return studentService.getStudentsByDiscipline(discipline)
                .stream()
                .map(student -> new StudentDTO(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getGroupName()
                )).collect(Collectors.toList());
    }
}

