package com.example.demo.Services;

import com.example.demo.Models.Discipline;
import com.example.demo.Models.Teacher;
import com.example.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("TeacherService")
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findTeacher(Teacher teacher){
        return teacherRepository.findById(teacher.getId());
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Boolean isTeacherOfDiscipline(Teacher teacher, Discipline discipline)
    {
        return teacher.getDisciplineList().contains(discipline);
    }

    public Teacher findTeacherByUsername(String username){
        return teacherRepository.findTeacherByUsername(username);
    }
}
