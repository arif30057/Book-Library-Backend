package com.j2ee.miniproject.bookLibrary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name="books" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long bookId;
    private String bookName;
    private String authorName;
    private String genre;
    private Integer totalPages;
    private Double price;
}
