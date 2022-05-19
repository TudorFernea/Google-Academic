package com.example.demo.Services;

import com.example.demo.Models.Faculty;
import com.example.demo.Repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("FacultyService")
public class FacultyService {
    private final FacultyRepository facultyRepository;


    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getFaculties(){
        return facultyRepository.findAll();
    }

    public Optional<Faculty> findFaculty(Faculty faculty){
        return facultyRepository.findById(faculty.getId());
    }

    public void addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

}
