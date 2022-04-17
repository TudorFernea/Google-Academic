package com.example.demo.Registration.Validators;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        // TODO: Regex to validate email
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(s).matches();
    }
}
