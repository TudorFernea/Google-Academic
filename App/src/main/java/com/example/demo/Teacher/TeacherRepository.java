package com.example.demo.Teacher;

import com.example.demo.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    // @Query("SELECT * FROM teacher t WHERE t.id = ?1")
    Optional<Teacher> findById(Long id);

}
