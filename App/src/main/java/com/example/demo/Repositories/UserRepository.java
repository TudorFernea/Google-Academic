package com.example.demo.Repositories;

import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository("UsersRepository")
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    Optional<User> findByEmail(String email);
}
