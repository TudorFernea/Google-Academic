package com.example.demo.Controllers;

import com.example.demo.Models.Curriculum;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.YearOfStudy;
import com.example.demo.Services.CurriculumService;
import com.example.demo.Services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController("CurriculumController")
@RequestMapping(value="api/curriculum")
public class CurriculumController {
    private final CurriculumService curriculumService;

    @Autowired
    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

    @GetMapping("/curriculums")
    public List<Curriculum> getCurriculums(){
        return curriculumService.getCurriculums();
    }

    @PostMapping
    public void addCurriculum(@RequestBody Curriculum curriculum) {
        curriculumService.addCurriculum(curriculum);
    }

    @GetMapping("/curriculumsByYear") //view the curriculum
    public Curriculum getCurriculumByYearOfStudy(YearOfStudy yearOfStudy){
        return curriculumService.getCurriculumByYearOfStudy(yearOfStudy);
    }
}
