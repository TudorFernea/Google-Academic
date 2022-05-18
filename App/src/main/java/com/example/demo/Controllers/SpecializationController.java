package com.example.demo.Controllers;

import com.example.demo.Models.Specialization;
import com.example.demo.Models.Student;
import com.example.demo.Services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("SpecializationController")
@RequestMapping(value="api/v1/specialization")
public class SpecializationController {

    private final SpecializationService specializationService;

    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    public List<Specialization> getSpecializations(){
        return specializationService.getSpecializations();
    }

    @PostMapping("/add")
    public void addSpecialization(@RequestBody Specialization specialization) {
        specializationService.addSpecialization(specialization);
    }
}
