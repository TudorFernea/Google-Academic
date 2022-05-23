package com.example.demo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Choice")
@Table(name = "choice")
@Getter
@Setter
public class Choice {

    public Choice() {
    }

    public Choice(Student student, Discipline discipline, Integer order) {
        this.student = student;
        this.discipline = discipline;
        this.choiceOrder = order;
    }

    @Id
    @SequenceGenerator(
            name = "choice_sequence",
            sequenceName = "choice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "choice_sequence"
    )
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentID")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disciplineID")
    private Discipline discipline;

    private Integer choiceOrder;
    private boolean verified=false;


    public Integer getId() {
        return id;
    }

    public Integer getOrder() {
        return choiceOrder;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Student getStudent() {
        return student;
    }


    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setOrder(Integer order) {
        this.choiceOrder = order;
    }

}
