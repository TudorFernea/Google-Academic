package com.example.demo.Repositories;

import com.example.demo.Models.Admin;
import com.example.demo.Models.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AdminRepository")
public interface AdminRepository extends JpaRepository<Admin, Integer>{
    Admin findAdminById(Integer Id);
}
