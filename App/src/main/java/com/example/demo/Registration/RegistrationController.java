package com.example.demo.Registration;

import com.example.demo.Models.User;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("RegistrationController")
@RequestMapping(path = "api/Registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    /*
    @PostMapping
    //     @PostMapping("/user/registration")
    public String register(@RequestBody RegistrationRequest request){
        // TODO: try catch for register method in the service
        return registrationService.register(request);
    }

     */
}
