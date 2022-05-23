package com.example.demo.DTOs;

import lombok.Data;

@Data
public class AddOptionalDTO {
    private String username;
    private String name;

    //private Integer maxNoOfStudents;

    private Integer nrcredit;
    private String description;
    private Integer yearOfStudyId;

    public AddOptionalDTO(String username, String name, Integer noOfCredits, String description, Integer yearOfStudyId) {
        this.username = username;
        this.name = name;
        this.nrcredit = noOfCredits;
        this.description = description;
        this.yearOfStudyId = yearOfStudyId;
    }
}
