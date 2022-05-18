package com.example.demo.Repositories;

import com.example.demo.Models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository("SpecializationRepository")
public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {
}
