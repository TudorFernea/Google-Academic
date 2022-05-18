package com.example.demo.Controllers;

import com.example.demo.Models.Faculty;
import com.example.demo.Services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("FacultyController")
@RequestMapping(value="api/v1/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public List<Faculty> getFaculties(){
        return facultyService.getFaculties();
    }

    @PostMapping("/add")
    public void addFaculty(@RequestBody Faculty faculty) {
        facultyService.addFaculty(faculty);
    }
}
