package com.example.demo.Optional;

import javax.persistence.*;

@Entity
@Table
public class OptionalDiscipline {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;
    private String name;
    private Integer credits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public OptionalDiscipline() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OptionalDiscipline(String name, Integer credits) {
        this.name = name;
        this.credits = credits;
    }

    public OptionalDiscipline(Long id, String name, Integer credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "OptionalDiscipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
