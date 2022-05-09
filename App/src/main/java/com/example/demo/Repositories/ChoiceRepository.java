package com.example.demo.Repositories;

import com.example.demo.Models.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ChoiceRepository")
public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
}
