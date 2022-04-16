package com.example.demo.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User ion = new User(
                    "Ion",
                    "abcd",
                    "fgfd",
                    "pop",
                    "ion"
            );

            User noi = new User(
                    "noi",
                    "abcd",
                    "fgfd",
                    "pop",
                    "noi"
            );

            repository.saveAll(
                    List.of(ion, noi)
            );
        };
    }

}
