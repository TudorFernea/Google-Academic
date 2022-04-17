package com.example.demo.Registration;

import com.example.demo.Registration.Validators.EmailValidator;
import com.example.demo.Registration.Validators.FirstNameValidator;
import com.example.demo.Registration.Validators.LastNameValidator;
import com.example.demo.Registration.Validators.UsernameValidator;
import com.example.demo.User.AppUserRole;
import com.example.demo.User.User;
import com.example.demo.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final UsernameValidator usernameValidator;
    private final FirstNameValidator firstNameValidator;
    private final LastNameValidator lastNameValidator;

    public String register(RegistrationRequest request) {
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

        return userService.signUpUser(new User(request.getUsername(), request.getPassword(), request.getEmail(), request.getFirstName(),
                request.getLastName(), AppUserRole.USER));
    }
}