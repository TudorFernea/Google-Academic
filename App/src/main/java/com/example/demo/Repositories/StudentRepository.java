package com.example.demo.Repositories;

import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StudentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer> {

}