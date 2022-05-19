package com.example.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Student")
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {

    public Student() {
    }

    public Student(String username, String password, String email, String firstName, String lastName, String groupName) {
        super(username, password, email, firstName, lastName);
        this.groupName = groupName;
    }


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "year_of_study1")
    private YearOfStudy yearOfStudy1;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "year_of_study2")
    private YearOfStudy yearOfStudy2;

    private String groupName;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Choice> choiceList =  new ArrayList<>();

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Choice> gradeList =  new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public YearOfStudy getYearOfStudy1() {
        return yearOfStudy1;
    }

    public YearOfStudy getYearOfStudy2() {
        return yearOfStudy2;
    }

    public String getGroups() {return this.groupName;}

    public List<Choice> getChoiceList() {
        return choiceList;
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

    public void setGroup(String group) {this.groupName = group;}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", yearOfStudy1=" + yearOfStudy1 +
                ", yearOfStudy2=" + yearOfStudy2 +
                ", group=" + groupName +
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

