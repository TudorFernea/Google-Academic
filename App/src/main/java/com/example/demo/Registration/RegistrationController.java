package com.example.demo.Registration;

import com.example.demo.Models.User;
import com.example.demo.Services.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("RegistrationController")
@RequestMapping(path = "api/Registration")
@AllArgsConstructor
public class RegistrationController {

    private SecurityService securityService;

    @PostMapping
    public boolean register(@RequestBody RegistrationRequest request){
        // TODO: try catch for register method in the service
        return securityService.register(request);
    }


}
