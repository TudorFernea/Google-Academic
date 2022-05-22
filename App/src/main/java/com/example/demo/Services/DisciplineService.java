package com.example.demo.Services;

import com.example.demo.Models.*;
import com.example.demo.Repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service("DisciplineService")
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<Discipline> getAllDiscipline(){
        return disciplineRepository.findAll();
    }
    public List<Discipline> getOptionals(){
        return disciplineRepository.findAll().stream().filter(Discipline::getOptional).collect(Collectors.toList());
    }
    public void addDiscipline(Discipline discipline) {
        disciplineRepository.save(discipline);
    }

    public List<Discipline> getDisciplinesByCurriculum(Curriculum curriculum) {
        return disciplineRepository.findDisciplineByCurriculum(curriculum);
    }

    public Double getAverageGrade(Discipline discipline){
        return discipline.getGradeList().stream().mapToInt(Grade::getValue).average().orElseThrow();
    }

    public Discipline getDisciplineWithBestResults(){

        Map.Entry<Discipline, Double> result = disciplineRepository.findAll().stream()
                .collect(Collectors.toMap(discipline -> discipline, discipline -> getAverageGrade(discipline))).entrySet().stream().max(comparingByValue()).orElseThrow();
        return result.getKey();
    }

    public List<Discipline> getDisciplineByTeacher(Teacher teacher)
    {
        return disciplineRepository.findDisciplineByTeacher(teacher);
    }

    public List<Discipline> getDisciplineByYearOfStudyAndTeacher(YearOfStudy yearOfStudy ,Teacher teacher)
    {
        return disciplineRepository.findDisciplineByYearOfStudyAndTeacher(yearOfStudy, teacher);
    }

    public List<Discipline> getDisciplineByYearOfStudy(YearOfStudy yearOfStudy)
    {
        return disciplineRepository.findDisciplineByYearOfStudy(yearOfStudy);
    }

    public Discipline getDiscipline(Integer id) {
        return disciplineRepository.findDisciplineById(id);
    }
}
