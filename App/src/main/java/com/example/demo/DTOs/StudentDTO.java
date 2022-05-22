package com.example.demo.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDTO implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String group;

    public StudentDTO(Integer id, String firstName, String lastName, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }
}
