package com.example.demo.Services;

import com.example.demo.Models.YearOfStudy;
import com.example.demo.Repositories.YearOfStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("YearOfStudyService")
public class YearOfStudyService {
    private final YearOfStudyRepository yearOfStudyRepository;

    @Autowired
    public YearOfStudyService(YearOfStudyRepository yearOfStudyRepository) {
        this.yearOfStudyRepository = yearOfStudyRepository;
    }

    public List<YearOfStudy> getAllYearOfStudy(){
        return yearOfStudyRepository.findAll();
    }

    public Optional<YearOfStudy> findYearOfStudy(Integer id){
        return yearOfStudyRepository.findById(id);
    }

    public void addYearOfStudy(YearOfStudy yearOfStudy) {
        yearOfStudyRepository.save(yearOfStudy);
    }
}
