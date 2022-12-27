package com.brico.ExtractToCsv.repo;

import com.brico.ExtractToCsv.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
