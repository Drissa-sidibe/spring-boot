package com.brico.ExtractToCsv.repo;

import com.brico.ExtractToCsv.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
