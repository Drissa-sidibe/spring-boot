package com.brico.ExtractToCsv;

import com.brico.ExtractToCsv.model.Student;
import com.brico.ExtractToCsv.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ExtractToCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtractToCsvApplication.class, args);
	}

}
