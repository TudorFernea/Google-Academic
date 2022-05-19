package com.example.demo.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Faculty")
@Table(name = "faculty")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Faculty{

    @Id
    @SequenceGenerator(
            name = "faculty_sequence",
            sequenceName = "faculty_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "faculty_sequence"
    )
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "specializationFaculty",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Specialization> specializationList = new ArrayList<>();

    @OneToMany(
            mappedBy = "teacherFaculty",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Teacher> teacherList = new ArrayList<>();

}
