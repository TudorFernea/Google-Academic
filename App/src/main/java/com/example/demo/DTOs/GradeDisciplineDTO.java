package com.example.demo.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class GradeDisciplineDTO implements Serializable {
    private Integer disciplineGrade;
    private String disciplineName;

    public GradeDisciplineDTO(Integer disciplineGrade, String disciplineName) {
        this.disciplineGrade = disciplineGrade;
        this.disciplineName = disciplineName;
    }
}
