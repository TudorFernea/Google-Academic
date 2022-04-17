package com.example.demo.Registration.Validators;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Predicate;

@Service
public class LastNameValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return !Objects.equals(s, "");
    }
}