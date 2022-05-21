package com.example.demo.Services;

import com.example.demo.Models.Teacher;
import com.example.demo.Models.User;
import com.example.demo.Repositories.AdminRepository;
import com.example.demo.Repositories.StudentRepository;
import com.example.demo.Repositories.TeacherRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@org.springframework.stereotype.Service("SecurityService")
public class SecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(User user){
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
        return userRepository.save(user);
    }

    public List<String> getRoles(String username) {
        List<String> result = new ArrayList<>();
        User user = userRepository.findByUsername(username);
        Integer id = user.getId();

        if (studentRepository.findStudentById(id) != null) {
            result.add("STUDENT");
        }
        if (teacherRepository.findTeacherById(id) != null) {
            Teacher teacher = teacherRepository.findTeacherById(id);
            result.add("TEACHER");
            if(teacher.getIsChief() == true)
                result.add("CHIEF");
        }
        if (adminRepository.findAdminById(id) != null) {
            result.add("ADMIN");
        }
        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        this.getRoles(user.getUsername()).forEach( role -> authorities.add(new SimpleGrantedAuthority(role)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
