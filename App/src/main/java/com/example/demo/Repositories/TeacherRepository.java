package com.example.demo.Repositories;

import com.example.demo.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("TeacherRepository")
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findTeacherById(Integer ID);
    Teacher findTeacherByUsername(String username);
}
