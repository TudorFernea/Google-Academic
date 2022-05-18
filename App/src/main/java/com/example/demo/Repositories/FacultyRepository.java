package com.example.demo.Repositories;

import com.example.demo.Models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FacultyRepository")
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
