package com.example.demo.Services;

import com.example.demo.Models.Specialization;
import com.example.demo.Repositories.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SpecializationService")
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public List<Specialization> getSpecializations(){
        return specializationRepository.findAll();
    }

    public Optional<Specialization> findSpecialization(Specialization specialization){
        return specializationRepository.findById(specialization.getId());
    }

    public void addSpecialization(Specialization specialization) {
        specializationRepository.save(specialization);
    }
}
