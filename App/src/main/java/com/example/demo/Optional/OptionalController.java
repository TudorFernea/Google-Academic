package com.example.demo.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/optional")
public class OptionalController {

    private final OptionalService optionalService;

    @Autowired
    public OptionalController(OptionalService optionalService) {
        this.optionalService = optionalService;
    }

    @GetMapping
    public List<OptionalDiscipline> getOptionals(){
        return optionalService.getOptionals();
    }

    @PostMapping
    public void addOptional(@RequestBody OptionalDiscipline optional) {
        optionalService.addOptional(optional);
    }
}
