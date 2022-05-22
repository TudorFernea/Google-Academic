package com.example.demo.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class YearOfStudyDTO implements Serializable {
    private Integer id;
    private Integer year;
    private String specializationName;

    public YearOfStudyDTO(Integer id, Integer year, String specialization) {
        this.id = id;
        this.year = year;
        this.specializationName = specialization;
    }
}
