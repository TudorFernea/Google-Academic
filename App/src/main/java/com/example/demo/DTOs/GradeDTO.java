package com.example.demo.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class GradeDTO implements Serializable {
    private String grade;
    private Integer disciplineId;
    private Integer studentId;

    public GradeDTO(String grade, Integer disciplineId, Integer studentId) {
        this.grade = grade;
        this.disciplineId = disciplineId;
        this.studentId = studentId;
    }
}
