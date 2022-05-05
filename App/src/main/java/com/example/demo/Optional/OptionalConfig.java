package com.example.demo.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OptionalConfig {

    @Bean
    CommandLineRunner commandLineRunner1(OptionalRepository repository){
        return args -> {
            OptionalDiscipline ion = new OptionalDiscipline(
                    "Ion",
                    1
            );

            OptionalDiscipline fp = new OptionalDiscipline(
                    "fp",
                    2
            );

            repository.saveAll(
                    List.of(ion, fp)
            );
        };
    }

}
