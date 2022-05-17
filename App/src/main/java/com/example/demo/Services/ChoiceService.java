package com.example.demo.Services;

import com.example.demo.Models.Choice;
import com.example.demo.Repositories.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ChoiceService")
public class ChoiceService {
    private final ChoiceRepository choiceRepository;

    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public List<Choice> getChoices(){
        return choiceRepository.findAll();
    }

    public void addChoice(Choice choice) {
        choiceRepository.save(choice);
    }
}
