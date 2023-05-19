package com.j2ee.miniproject.bookLibrary.controller;

import com.j2ee.miniproject.bookLibrary.model.UserAuthenticationRequest;
import com.j2ee.miniproject.bookLibrary.model.UserAuthenticationResponse;
import com.j2ee.miniproject.bookLibrary.service.implementation.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/login")

public class UserAuthenticationController {

    private final AuthenticationService authService;

    @PostMapping
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody UserAuthenticationRequest authReq){
        return new ResponseEntity<>(authService.login(authReq) , HttpStatus.OK);
    }
}
