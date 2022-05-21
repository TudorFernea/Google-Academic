package com.example.demo.Services;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service("UserService")
@AllArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final static String USER_NOT_FOUND_MSG = "user with username %s not found";

    public List<User> getUsers(){
        return userRepository.findAll();
    }


    /*
    public String signUpUser(User user){
        boolean userExists = userRepository.findByUsername(user.getUsername()).isPresent();

        if(userExists){
            throw new IllegalStateException("username already taken");
        }

        userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("email already used");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        // TODO: SEND confirmation token

        return "register_success";
    }*/
}
