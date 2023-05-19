package com.j2ee.miniproject.bookLibrary.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookCreateModel{
    private String bookName;
    private String authorName;
    private String genre;
    private Integer totalPages;
    private Double price;
}
