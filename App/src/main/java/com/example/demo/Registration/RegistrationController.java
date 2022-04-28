package com.example.demo.Registration;

import com.example.demo.User.User;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping(path = "api/v1/Registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    //     @PostMapping("/user/registation")
    public String register(@RequestBody RegistrationRequest request){
        // TODO: try catch for register method in the service
        return registrationService.register(request);
    }
}
