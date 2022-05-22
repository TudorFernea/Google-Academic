package com.example.demo.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Specialization")
@Table(name = "specialization")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Specialization {

    public Specialization(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Id
    @SequenceGenerator(
            name = "specialization_sequence",
            sequenceName = "specialization_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "specialization_sequence"
    )
    private Integer id;

    private String name;

    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facultyId")
    private Faculty specializationFaculty;

    @OneToMany(
            mappedBy = "specialization",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<YearOfStudy> yearOfStudyList = new ArrayList<>();
}
