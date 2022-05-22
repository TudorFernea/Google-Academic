package com.example.demo.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Curriculum")
@Table(name = "curriculum")
@Getter
@Setter
@NoArgsConstructor
public class Curriculum {

    public Curriculum(String text, Discipline discipline) {
        this.text = text;
        this.discipline = discipline;
    }

    public Curriculum(String text) {
        this.text = text;
    }

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
    private String text;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "disciplineId")
    private Discipline discipline;

}
