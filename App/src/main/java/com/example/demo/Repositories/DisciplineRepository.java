package com.example.demo.Repositories;

import com.example.demo.Models.Curriculum;
import com.example.demo.Models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DisciplineRepository")
public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {

    public List<Discipline> findDisciplineByCurriculum(Curriculum curriculum);

}
