package com.j2ee.miniproject.bookLibrary.controller;

import com.j2ee.miniproject.bookLibrary.model.UserCreateModel;
import com.j2ee.miniproject.bookLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService userservice;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserCreateModel user){
        return userservice.registerNewUser(user);
    }
}
