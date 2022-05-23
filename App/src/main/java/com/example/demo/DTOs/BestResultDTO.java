package com.example.demo.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class BestResultDTO implements Serializable {
    private String disciplineName;
    private Double averageGrade;

    public BestResultDTO(String disciplineName, Double averageGrade) {
        this.disciplineName = disciplineName;
        this.averageGrade = averageGrade;
    }
}
