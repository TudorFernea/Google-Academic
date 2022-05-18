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

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "disciplineId")
    private Discipline discipline;

}
