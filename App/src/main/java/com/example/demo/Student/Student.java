package com.example.demo.Student;

import com.example.demo.User.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Student extends User {

    public Student(Long id, Integer yearOfStudy1, Integer yearOfStudy2) {
        this.id = id;
        this.yearOfStudy1 = yearOfStudy1;
        this.yearOfStudy2 = yearOfStudy2;
    }

    public Student(Long id, String username, String password, String email, String firstName, String lastName, Integer yearOfStudy1, Integer yearOfStudy2) {
        super(id, username, password, email, firstName, lastName);
        this.id = id;
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

    private Long id;
    private Integer yearOfStudy1;
    private Integer yearOfStudy2;

    public Long getId() {
        return id;
    }

    public Integer getYearOfStudy1() {
        return yearOfStudy1;
    }

    public Integer getYearOfStudy2() {
        return yearOfStudy2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYearOfStudy1(Integer yearOfStudy1) {
        this.yearOfStudy1 = yearOfStudy1;
    }

    public void setYearOfStudy2(Integer yearOfStudy2) {
        this.yearOfStudy2 = yearOfStudy2;
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
        return id.equals(student.id) && Objects.equals(yearOfStudy1, student.yearOfStudy1) && Objects.equals(yearOfStudy2, student.yearOfStudy2);
    }

}

