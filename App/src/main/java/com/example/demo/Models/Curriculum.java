package com.example.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Curriculum")
@Table(name = "curriculum")
public class Curriculum {
    @Id
    @SequenceGenerator(
            name = "curriculum_sequence",
            sequenceName = "curriculum_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "curriculum_sequence"
    )
    private Integer id;

    @OneToMany(
            mappedBy = "curriculum",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Discipline> disciplineList =  new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private YearOfStudy yearOfStudy;

}
