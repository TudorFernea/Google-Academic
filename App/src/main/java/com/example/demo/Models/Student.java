package com.example.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Student")
@Table(name = "student")
public class Student extends User {

    public Student() {
    }

    public Student(Integer id, YearOfStudy yearOfStudy1, YearOfStudy yearOfStudy2) {
        this.id = id;
        this.yearOfStudy1 = yearOfStudy1;
        this.yearOfStudy2 = yearOfStudy2;
    }

    public Student(Integer id, String username, String password, String email, String firstName, String lastName, YearOfStudy yearOfStudy1, YearOfStudy yearOfStudy2) {
        super(id, username, password, email, firstName, lastName);
        this.yearOfStudy1 = yearOfStudy1;
        this.yearOfStudy2 = yearOfStudy2;
    }

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "year_of_study1")
    private YearOfStudy yearOfStudy1;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "year_of_study2")
    private YearOfStudy yearOfStudy2;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Choice> choiceList =  new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public YearOfStudy getYearOfStudy1() {
        return yearOfStudy1;
    }

    public YearOfStudy getYearOfStudy2() {
        return yearOfStudy2;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setYearOfStudy1(YearOfStudy yearOfStudy1) {
        this.yearOfStudy1 = yearOfStudy1;
    }

    public void setYearOfStudy2(YearOfStudy yearOfStudy2) {
        this.yearOfStudy2 = yearOfStudy2;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", yearOfStudy1=" + yearOfStudy1 +
                ", yearOfStudy2=" + yearOfStudy2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}

