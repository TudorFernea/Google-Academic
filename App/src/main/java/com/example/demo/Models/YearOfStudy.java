package com.example.demo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "YearOfStudy")
@Table(name = "year_of_study")
@Getter
@Setter
public class YearOfStudy {

    public YearOfStudy() {
    }

    public YearOfStudy(Integer year, List<Student> student1List, List<Student> student2List) {
        this.year = year;
        this.student1List = student1List;
        this.student2List = student2List;
    }

    @Id
    @SequenceGenerator(
            name = "year_sequence",
            sequenceName = "year_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "year_sequence"
    )
    private Integer id;
    private Integer year;

    @OneToMany(
            mappedBy = "yearOfStudy1",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Student> student1List =  new ArrayList<>();

    @OneToMany(
            mappedBy = "yearOfStudy2",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Student> student2List =  new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specializationId")
    private Specialization specialization;

    @OneToMany(
            mappedBy = "yearOfStudy",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Discipline> disciplineList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Student> getStudent1List() {
        return student1List;
    }
    public void setStudent1List(List<Student> student1List) {
        this.student1List = student1List;
    }

    public List<Student> getStudent2List() {
        return student2List;
    }
    public void setStudent2List(List<Student> student2List) {
        this.student2List = student2List;
    }
}
