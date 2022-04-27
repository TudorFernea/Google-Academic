package com.example.demo.Teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeacherConfig {
    @Bean
    CommandLineRunner teacherCommandLineRunner(TeacherRepository repository) {
        return args -> {
            Teacher One = new Teacher(
                    10L,
                    10L,
                    true
            );
            Teacher Two = new Teacher(
                    20L,
                    false
            );
            repository.saveAll(List.of(One, Two));
        };
    }
}