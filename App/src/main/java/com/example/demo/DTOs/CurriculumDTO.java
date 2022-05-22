package com.example.demo.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class CurriculumDTO implements Serializable {
    private Integer id;
    private String text;

    public CurriculumDTO(Integer id, String text) {
        this.id = id;
        this.text = text;
    }
}
