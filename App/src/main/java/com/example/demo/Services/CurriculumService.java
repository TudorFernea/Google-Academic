package com.example.demo.Services;

import com.example.demo.Models.Curriculum;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.YearOfStudy;
import com.example.demo.Repositories.CurriculumRepository;
import com.example.demo.Repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CurriculumService")
public class CurriculumService {
    private final CurriculumRepository curriculumRepository;

    @Autowired
    public CurriculumService(CurriculumRepository curriculumRepository) {
        this.curriculumRepository = curriculumRepository;
    }

    public List<Curriculum> getCurriculums(){
        return curriculumRepository.findAll();
    }

    public Curriculum getCurriculumByYearOfStudy(YearOfStudy yearOfStudy){
        return curriculumRepository.findCurriculumByYearOfStudy(yearOfStudy);
    }

    public void addCurriculum(Curriculum curriculum) {
        curriculumRepository.save(curriculum);
    }
}
