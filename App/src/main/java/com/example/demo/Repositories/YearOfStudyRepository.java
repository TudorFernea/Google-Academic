package com.example.demo.Repositories;

import com.example.demo.Models.YearOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("YearOfStudyRepository")
public interface YearOfStudyRepository extends JpaRepository<YearOfStudy, Integer> {
}
