package com.example.BookMuseum.Controller;

import com.example.BookMuseum.Model.Book;
import com.example.BookMuseum.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService service;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(service.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("book/add")
    public ResponseEntity<Boolean> addBook(@RequestBody Book book){
        return new ResponseEntity<>(service.addBook(book), HttpStatus.OK);
    }

    @PutMapping("book/update/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable Long bookId, @RequestBody Book book){
        if(service.updateBook(bookId, book)){
            service.updateBook(bookId, book);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("book/delete/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId){
        if(service.deleteBook(bookId))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
