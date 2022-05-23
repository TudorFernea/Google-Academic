package com.example.demo.Services;

import com.example.demo.Models.Choice;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Student;
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

    public void deleteAll(){
        choiceRepository.deleteAll();
    }

    public void deleteAllByList(List<Choice> list){
        choiceRepository.deleteAll(list);
    }

    public List<Choice> getChoicesByDiscipline(Discipline discipline){
        return choiceRepository.findChoiceByDiscipline(discipline);
    }

    public List<Choice> getChoicesByStudent(Student student){
        return choiceRepository.findChoiceByStudent(student);
    }
}
