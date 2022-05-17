package com.example.demo.Repositories;

import com.example.demo.Models.Curriculum;
import com.example.demo.Models.YearOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CurriculumRepository")
public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {

    public Curriculum findCurriculumByYearOfStudy(YearOfStudy yearOfStudy);

}
