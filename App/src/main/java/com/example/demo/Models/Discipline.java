package com.example.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Discipline")
@Table(name = "discipline")
public class Discipline {

    public Discipline() {
    }

    public Discipline(String name, Boolean optional, Integer noOfCredits) {
        this.name = name;
        this.optional = optional;
        this.noOfCredits = noOfCredits;
    }

    public Discipline(Integer id, String name, Boolean optional) {
        this.id = id;
        this.name = name;
        this.optional = optional;
    }

    public Discipline(String name, Boolean optional, Integer noOfCredits, Curriculum curriculum, Teacher teacher)
    {
        this.name = name;
        this.optional = optional;
        this.noOfCredits = noOfCredits;
        this.curriculum = curriculum;
        this.teacher = teacher;
    }

    @Id
    @SequenceGenerator(
            name = "discipline_sequence",
            sequenceName = "discipline_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "discipline_sequence"
    )
    private Integer id;
    private String name;
    private Boolean optional;

    private Integer maxNoOfStudents;

    private Integer noOfCredits;

    @OneToMany(
            mappedBy = "discipline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Choice> choiceList = new ArrayList<>();

    @OneToMany(
            mappedBy = "discipline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Grade> gradeList = new ArrayList<>();

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "curriculumId")
    private Curriculum curriculum;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "yearOfStudyId")
    private YearOfStudy yearOfStudy;

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Integer getId() {
        return id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public Integer getMaxNoOfStudents() {
        return maxNoOfStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setMaxNoOfStudents(Integer maxNoOfStudents) {
        this.maxNoOfStudents = maxNoOfStudents;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public Integer getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(Integer noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    public YearOfStudy getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(YearOfStudy yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
