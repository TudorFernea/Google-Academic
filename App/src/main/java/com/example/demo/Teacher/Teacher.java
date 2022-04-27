package com.example.demo.Teacher;

import javax.persistence.*;

@Entity
@Table
public class Teacher {
    private Long id;
    private Long facultyID;
    private Boolean isChief;

    public Teacher() {}

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Long facultyID) {
        this.facultyID = facultyID;
    }

    public Boolean getChief() {
        return isChief;
    }

    public void setChief(Boolean chief) {
        isChief = chief;
    }

    public Teacher(Long facultyID, Boolean isChief) {
        this.facultyID = facultyID;
        this.isChief = isChief;
    }

    public Teacher(Long id, Long facultyID, Boolean isChief) {
        this.id = id;
        this.facultyID = facultyID;
        this.isChief = isChief;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", facultyID=" + facultyID +
                ", isChief=" + isChief +
                '}';
    }
}
