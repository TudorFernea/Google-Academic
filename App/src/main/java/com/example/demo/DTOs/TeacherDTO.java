package com.example.demo.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherDTO implements Serializable {
    private Integer id;
    private String name;
    private String surname;

    public TeacherDTO(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
