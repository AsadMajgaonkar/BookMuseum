package com.example.BookMuseum.Service;

import com.example.BookMuseum.Model.Book;
import com.example.BookMuseum.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repo;

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Boolean addBook(Book book) {
        repo.save(book);
        return true;
    }

    public Boolean updateBook(Long bookId, Book newBook) {
        Book book = repo.findById(bookId).orElse(null);
        if(book!=null){
            repo.save(newBook);
            return true;
        }
        return false;
    }

    public boolean deleteBook(Long bookId) {
        Book book = repo.findById(bookId).orElse(null);
        if(book!=null){
            repo.deleteById(bookId);
            return true;
        }
        return false;
    }
}
