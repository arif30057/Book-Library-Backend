package com.j2ee.miniproject.bookLibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserAuthenticationRequest {
    private String email;
    private String password;
}
