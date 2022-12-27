package com.brico.ExtractToCsv.config;

import com.brico.ExtractToCsv.model.Student;
import com.brico.ExtractToCsv.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

            Student student = new Student(1,
                    "Drissa",

                    "GuelleTapee",
                    "Dakar",
                    "7878");

            Student fam = new Student(2,
                    "Fam",
                    "GuelleTapee",
                    "Dakar",
                    "7879"
            );
            Student fant = new Student(3,
                    "Fanta",
                    "Diboli",
                    "Dibol",
                    "7890"
            );
            Student sali = new Student(4,
                    "Sali",
                    "Mougoula",
                    "Mourgoula",
                    "7889"
            );
            repository.saveAll(List.of(student, fam,fant,sali));
        };

    }
}
