package com.example.demo.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionalService {

    private final OptionalRepository optionalRepository;

    @Autowired
    public OptionalService(OptionalRepository optionalRepository) {
        this.optionalRepository = optionalRepository;
    }

    public List<OptionalDiscipline> getOptionals(){
        return optionalRepository.findAll();
    }


    public void addOptional(OptionalDiscipline optionalDiscipline) {
        optionalRepository.save(optionalDiscipline);
    }
}
