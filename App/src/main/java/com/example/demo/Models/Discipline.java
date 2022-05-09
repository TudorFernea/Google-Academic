package com.example.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Discipline")
@Table(name = "discipline")
public class Discipline {

    public Discipline() {
    }

    public Discipline(String name, Boolean optional) {
        this.name = name;
        this.optional = optional;
    }

    public Discipline(Integer id, String name, Boolean optional) {
        this.id = id;
        this.name = name;
        this.optional = optional;
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

    @OneToMany(
            mappedBy = "discipline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Choice> choiceList = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "curriculum")
    private Curriculum curriculum;

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

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

}
