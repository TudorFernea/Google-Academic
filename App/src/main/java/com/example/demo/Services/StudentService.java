package com.example.demo.Services;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("StudentService")
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> findStudent(Student student){
        return studentRepository.findById(student.getId());
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void getStudentGrades(Student student) {

    }
}