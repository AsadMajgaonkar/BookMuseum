package com.example.BookMuseum.Repository;

import com.example.BookMuseum.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
