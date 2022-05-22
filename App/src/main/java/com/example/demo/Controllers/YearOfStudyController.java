package com.example.demo.Controllers;

import com.example.demo.DTOs.YearOfStudyDTO;
import com.example.demo.Models.Discipline;
import com.example.demo.Models.Teacher;
import com.example.demo.Models.YearOfStudy;
import com.example.demo.Services.TeacherService;
import com.example.demo.Services.YearOfStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("YearOfStudyController")
@RequestMapping(value="api/yearOfStudy")
public class YearOfStudyController {

    private final YearOfStudyService yearOfStudyService;

    @Autowired
    public YearOfStudyController(YearOfStudyService yearOfStudyService) {
        this.yearOfStudyService = yearOfStudyService;
    }

    @GetMapping("/getAll")
    public List<YearOfStudyDTO> getAllYearOfStudy(){
        return yearOfStudyService.getAllYearOfStudy()
                .stream()
                .map(year -> new YearOfStudyDTO(
                        year.getId(),
                        year.getYear(),
                        year.getSpecialization().getName()
                        ))
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public void addYearOfStudy(@RequestBody YearOfStudy yearOfStudy) {
        yearOfStudyService.addYearOfStudy(yearOfStudy);
    }


}