package com.example.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "YearOfStudy")
@Table(name = "year_of_study")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curriculum")
    private Curriculum curriculum;

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

    public Curriculum getCurriculum() {
        return curriculum;
    }
    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }
}
