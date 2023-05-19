package com.j2ee.miniproject.bookLibrary.service.implementation;

import com.j2ee.miniproject.bookLibrary.model.UserAuthenticationRequest;
import com.j2ee.miniproject.bookLibrary.model.UserAuthenticationResponse;
import com.j2ee.miniproject.bookLibrary.repository.UserRepository;
import com.j2ee.miniproject.bookLibrary.utilities.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtUtilities jwtService;
    private final AuthenticationManager authManager;
    private final UserRepository userRepo;

    public UserAuthenticationResponse login(UserAuthenticationRequest authReq){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authReq.getEmail(),
                        authReq.getPassword()
                )
        );
        var user = userRepo.findByEmail(authReq.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return UserAuthenticationResponse.builder()
                .token(jwtToken)
                .build()
                ;
    }
}
