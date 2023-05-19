package com.j2ee.miniproject.bookLibrary.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserCreateModel {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private String role;
}
