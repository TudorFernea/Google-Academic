package com.example.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ListAssignDTO implements Serializable {
    private List<AssignDTO> first;
    private List<AssignDTO> second;

    public ListAssignDTO(List<AssignDTO> first, List<AssignDTO> second) {
        this.first = first;
        this.second = second;
    }
}
