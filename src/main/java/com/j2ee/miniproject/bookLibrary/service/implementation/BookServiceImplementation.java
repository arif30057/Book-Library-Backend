package com.j2ee.miniproject.bookLibrary.service.implementation;

import com.j2ee.miniproject.bookLibrary.entity.BookEntity;
import com.j2ee.miniproject.bookLibrary.model.BookCreateModel;
import com.j2ee.miniproject.bookLibrary.repository.BookRepository;
import com.j2ee.miniproject.bookLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookServiceImplementation implements BookService, UserDetailsService {

    private final BookRepository bookRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Object> addNewBook(BookCreateModel book) {
        BookEntity newBook = BookEntity.builder()
                .bookName(book.getBookName())
                .authorName(book.getAuthorName())
                .genre(book.getGenre())
                .totalPages(book.getTotalPages())
                .price(book.getPrice())
                .build();
        BookEntity saveBook = bookRepo.save(newBook);
        return new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }

    @Override
    public List<BookEntity> showAllBooks() {
        List<BookEntity> books = bookRepo.findAll();
        return books;
//        return bookRepo.findAll();
    }

    @Override
    public void deleteById(Long bookId) {
        BookEntity book = bookRepo.findById(bookId).get();
        bookRepo.delete(book);
    }

    @Override
    public ResponseEntity<Object> updateById(Long bookId , BookEntity anotherBook) {
        BookEntity book = bookRepo.findById(bookId).get();
        book.setBookName(anotherBook.getBookName());
        book.setAuthorName(anotherBook.getAuthorName());
        book.setGenre(anotherBook.getGenre());
        book.setTotalPages(anotherBook.getTotalPages());
        book.setPrice(anotherBook.getPrice());
        bookRepo.save(book);
        return new ResponseEntity<>(book , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> findById(Long bookId) {
        BookEntity book = bookRepo.findById(bookId).get();
        return new ResponseEntity<>(book , HttpStatus.OK);
    }

    @Override
    public List<BookEntity> findByAuthorName(String authorName) {
        List<BookEntity> book = bookRepo.findByAuthorName(authorName);
        return book;
    }

    @Override
    public List<BookEntity> findByAuthorNameAndBookName(String authorName, String bookName) {
        return bookRepo.findByAuthorNameAndBookName(authorName , bookName);
    }

}
