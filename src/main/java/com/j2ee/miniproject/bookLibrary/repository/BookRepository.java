package com.j2ee.miniproject.bookLibrary.repository;

import com.j2ee.miniproject.bookLibrary.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findByAuthorName(String authorName);
    List<BookEntity> findByAuthorNameAndBookName(String authorName, String bookName);
}
