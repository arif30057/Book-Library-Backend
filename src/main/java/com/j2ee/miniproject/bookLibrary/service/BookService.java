package com.j2ee.miniproject.bookLibrary.service;

import com.j2ee.miniproject.bookLibrary.entity.BookEntity;
import com.j2ee.miniproject.bookLibrary.model.BookCreateModel;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BookService {
    ResponseEntity<Object> addNewBook(BookCreateModel book);
    List<BookEntity> showAllBooks( );
    void deleteById(Long bookId);
    ResponseEntity<Object> updateById(Long bookId , BookEntity anotherBook);
    ResponseEntity<Object> findById(Long bookId);
    List<BookEntity> findByAuthorName(String authorName);
    List<BookEntity> findByAuthorNameAndBookName(String authorName , String bookName);
}