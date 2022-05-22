package com.example.demo.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class DisciplineDTO implements Serializable {
    private Integer id;
    private String name;
    private Boolean optional;

    //private Integer maxNoOfStudents;

    private Integer credits;
    private CurriculumDTO curriculum;

    public DisciplineDTO(Integer id, String name, Boolean optional, Integer credits, CurriculumDTO curriculum) {
        this.id = id;
        this.name = name;
        this.optional = optional;
        this.credits = credits;
        this.curriculum = curriculum;
    }
}
