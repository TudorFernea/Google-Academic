package com.example.demo.Repositories;

import com.example.demo.Models.Curriculum;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Teacher;
import com.example.demo.Models.YearOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DisciplineRepository")
public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {

    List<Discipline> findDisciplineByCurriculum(Curriculum curriculum);
    List<Discipline> findDisciplineByTeacher(Teacher teacher);
    List<Discipline> findDisciplineByYearOfStudyAndTeacher(YearOfStudy yearOfStudy, Teacher teacher);
    List<Discipline> findDisciplineByYearOfStudy(YearOfStudy yearOfStudy);
    Discipline findDisciplineById(Integer id);
}
