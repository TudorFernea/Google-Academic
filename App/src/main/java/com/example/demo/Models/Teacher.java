package com.example.demo.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity(name="Teacher")
@Table(name="teacher")
@PrimaryKeyJoinColumn(name = "id")
public class Teacher extends User{

    public Teacher(String username, String password, String email, String firstName, String lastName, boolean isChief) {
        super(username, password, email, firstName, lastName);
        this.isChief = isChief;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facultyId")
    private Faculty teacherFaculty;

    private Boolean isChief;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Discipline> disciplineList = new ArrayList<>();

}
