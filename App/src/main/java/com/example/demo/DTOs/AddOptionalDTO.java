package com.example.demo.DTOs;

import lombok.Data;

@Data
public class AddOptionalDTO {
    private String username;
    private String name;

    //private Integer maxNoOfStudents;

    private Integer nrcredit;
    private String description;

    public AddOptionalDTO(String username, String name, Integer noOfCredits, String description) {
        this.username = username;
        this.name = name;
        this.nrcredit = noOfCredits;
        this.description = description;
    }
}
