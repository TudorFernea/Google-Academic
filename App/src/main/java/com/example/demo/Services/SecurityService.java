package com.example.demo.Services;

import com.example.demo.Models.Student;
import com.example.demo.Models.Teacher;
import com.example.demo.Models.User;
import com.example.demo.Registration.RegistrationRequest;
import com.example.demo.Registration.Validators.EmailValidator;
import com.example.demo.Registration.Validators.FirstNameValidator;
import com.example.demo.Registration.Validators.LastNameValidator;
import com.example.demo.Registration.Validators.UsernameValidator;
import com.example.demo.Repositories.AdminRepository;
import com.example.demo.Repositories.StudentRepository;
import com.example.demo.Repositories.TeacherRepository;
import com.example.demo.Repositories.UserRepository;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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

    private final EmailValidator emailValidator;
    private final UsernameValidator usernameValidator;
    private final FirstNameValidator firstNameValidator;
    private final LastNameValidator lastNameValidator;

    public User addUser(User user){
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public String signUpUser(User user){
        boolean userExists = true;

        if(userRepository.findByUsername(user.getUsername()) ==  null);
            userExists = false;

        if(userExists){
            throw new IllegalStateException("username already taken");
        }

        userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("email already used");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }

    public boolean register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        boolean isValidUsername = usernameValidator.test(request.getUsername());
        if(!isValidUsername){
            throw new IllegalStateException("username not valid");
        }

        boolean isValidFirstName = firstNameValidator.test(request.getFirstName());
        if(!isValidFirstName){
            throw new IllegalStateException("first name not valid");
        }

        boolean isValidLastName = lastNameValidator.test(request.getLastName());
        if(!isValidLastName){
            throw new IllegalStateException("last name not valid");
        }

        if(!request.getPassword().equals(request.getConfirmationPassword()))
        {
            throw new IllegalStateException("confirmation password does not match with the initial password");
        }

        // TODO: Handle the type of user and create the object to respect to that
        if(request.getRole().equals(new String("STUDENT")))
        {
            Student student = new Student(request.getUsername(), request.getPassword(), request.getEmail(), request.getFirstName(),
                    request.getLastName(),"923");
            String respone = signUpUser(student);
            studentRepository.save(student);
            return true;
        }
        else
        if(request.getRole().equals(new String("TEACHER")))
        {
            Teacher teacher = new Teacher(request.getUsername(), request.getPassword(), request.getEmail(), request.getFirstName(),
                    request.getLastName(),false);
            String respone = signUpUser(teacher);
            teacherRepository.save(teacher);
            return true;
        }
        return false;
        //else
          //  (request.getRole() == "TEACHER")

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
            if(teacher.getIsChief() == false)
                result.add("TEACHER");
            else
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
