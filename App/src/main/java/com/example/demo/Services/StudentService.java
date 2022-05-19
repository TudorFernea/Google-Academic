package com.example.demo.Services;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Discipline> getDisciplinesOfAStudent(Student student)
    {
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.addAll(student.getYearOfStudy1().getDisciplineList());
        disciplines.addAll(student.getYearOfStudy2().getDisciplineList());
        return disciplines;
    }

    public List<Student> getStudentsByDiscipline(Discipline discipline)
    {
        List<Student> students = getStudents();
        for(Student s : students)
        {
            if(!getDisciplinesOfAStudent(s).contains(discipline))
            {
                students.remove(s);
            }
        }
        return students;
    }
}