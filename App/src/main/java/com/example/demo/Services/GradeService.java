package com.example.demo.Services;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Grade;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.DisciplineRepository;
import com.example.demo.Repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GradeService")
public class GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getGrades(){
        return gradeRepository.findAll();
    }

    public List<Grade> getGradesByStudent(Student student){
        return gradeRepository.findGradeByStudent(student);
    }

    public void addGrade(Grade grade) {
        gradeRepository.save(grade);
    }
}
