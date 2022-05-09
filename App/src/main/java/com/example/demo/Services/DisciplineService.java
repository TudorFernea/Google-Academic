package com.example.demo.Services;

import com.example.demo.Models.Curriculum;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DisciplineService")
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<Discipline> getDisciplines(){
        return disciplineRepository.findAll();
    }


    public void addDiscipline(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    public List<Discipline> getDisciplinesByCurriculum(Curriculum curriculum) {
        return disciplineRepository.findDisciplineByCurriculum(curriculum);
    }
}
