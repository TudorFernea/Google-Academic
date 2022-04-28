package com.example.demo.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionalRepository extends JpaRepository<OptionalDiscipline, Long> {

}
