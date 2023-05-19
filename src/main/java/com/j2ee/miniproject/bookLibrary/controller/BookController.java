package com.j2ee.miniproject.bookLibrary.controller;

import com.j2ee.miniproject.bookLibrary.entity.BookEntity;
import com.j2ee.miniproject.bookLibrary.model.BookCreateModel;
import com.j2ee.miniproject.bookLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor

public class BookController {

    public final BookService bookservice;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody BookCreateModel newBook){
        return bookservice.addNewBook(newBook);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Object> update(@PathVariable Long bookId , @RequestBody BookEntity anotherBook){
        return bookservice.updateById(bookId,anotherBook);
    }

    @DeleteMapping("/delete/{bookId}")
    public void delete(@PathVariable Long bookId){
        bookservice.deleteById(bookId);
    }

    @GetMapping("/all")
    public List<BookEntity> showAll(){
        return bookservice.showAllBooks();
    }

    @GetMapping("/id/{bookId}")
    public ResponseEntity<Object> showById(@PathVariable Long bookId){
        return bookservice.findById(bookId);
    }

    @GetMapping("/author/{authorName}")
    public List<BookEntity> showByAuthor(@PathVariable String authorName){
        return bookservice.findByAuthorName(authorName);
    }

    @GetMapping("/author/{authorName}/{bookName}")
    public List<BookEntity> showByAuthorAndBookName(@PathVariable String authorName , @PathVariable String bookName){
        return bookservice.findByAuthorNameAndBookName(authorName , bookName);
    }
}
