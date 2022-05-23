package com.example.demo.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class AssignDTO implements Serializable {
    private Integer id;
    private Integer noStudents;

    public AssignDTO(Integer id, Integer noStudents) {
        this.id = id;
        this.noStudents = noStudents;
    }
}
