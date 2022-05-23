package com.example.demo.Repositories;

import com.example.demo.Models.Choice;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ChoiceRepository")
public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
    List<Choice> findChoiceByDiscipline(Discipline discipline);

    List<Choice> findChoiceByStudent(Student student);
}
