package com.example.demo.Repositories;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Grade;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("GradeRepository")
public interface GradeRepository  extends JpaRepository<Grade, Integer> {

    public List<Grade> findGradeByStudent(Student student);
    public List<Grade> findGradeByStudentAndDiscipline(Student student, Discipline discipline);

}
