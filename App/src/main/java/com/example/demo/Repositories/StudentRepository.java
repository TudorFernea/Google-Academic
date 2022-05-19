package com.example.demo.Repositories;

import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.List;

@Repository("StudentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query("SELECT AVG(g.) FROM user_rating e WHERE e.route_uid = ?1")
//    fun averageOfRateings(routeId: UUID): Long
//
//    @Query("SELECT s from Student s where s.group  = :studentGroup group s.category order by :categoryName")
//    Set<Student> getStudentsByGroupOrderedByGrade(@Param("group") String studentGroup, @Param("categoryName") String categoryName);


}