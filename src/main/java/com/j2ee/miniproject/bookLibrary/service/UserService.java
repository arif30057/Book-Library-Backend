package com.j2ee.miniproject.bookLibrary.service;

import com.j2ee.miniproject.bookLibrary.model.UserCreateModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> registerNewUser(UserCreateModel user);
}
