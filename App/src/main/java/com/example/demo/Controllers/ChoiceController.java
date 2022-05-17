package com.example.demo.Controllers;

import com.example.demo.Models.Choice;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
import com.example.demo.Services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("ChoiceController")
@RequestMapping(value="api/choice")
public class ChoiceController {

    private final ChoiceService choiceService;

    @Autowired
    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @PostMapping
    public String chooseOptional(@RequestBody Student student, Discipline discipline, Integer order){
        Choice choice = new Choice(student, discipline, order);
        choiceService.addChoice(choice);
        return "200";
    }
}
