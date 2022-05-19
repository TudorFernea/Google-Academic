package com.example.demo.Services;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Grade;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.DisciplineRepository;
import com.example.demo.Repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    //TODO: Added by Luana on 18.05
    public Double getProfessionalResults() {

//        List<Grade> grades = getGradesByStudent(student);
//        Student testStudent = new Student();

        Grade g1 = new Grade();
        g1.setValue(10);
        Grade g2 = new Grade();
        g2.setValue(2);
        Grade g3 = new Grade();
        g3.setValue(9);

        List<Grade> grades = new ArrayList<>();
        grades.add(g1);
        grades.add(g2);
        grades.add(g3);

        int sum = 0;
        int count = 0;
        System.out.println("Initial sum: " + sum);
        for (Grade g : grades) {
            sum += g.getValue();
            count += 1;
        }
        double average = 0.0;
        if (count > 0)
            average = (sum * 1.0) / count;

        System.out.println("Average: " + average);
        return average;
    }

    public void addGrade(Grade grade) {
        gradeRepository.save(grade);
    }
}
