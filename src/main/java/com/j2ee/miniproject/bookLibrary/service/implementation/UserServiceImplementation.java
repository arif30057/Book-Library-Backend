package com.j2ee.miniproject.bookLibrary.service.implementation;

import com.j2ee.miniproject.bookLibrary.entity.UserEntity;
import com.j2ee.miniproject.bookLibrary.model.UserAuthenticationResponse;
import com.j2ee.miniproject.bookLibrary.model.UserCreateModel;
import com.j2ee.miniproject.bookLibrary.repository.UserRepository;
import com.j2ee.miniproject.bookLibrary.service.UserService;
import com.j2ee.miniproject.bookLibrary.utilities.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImplementation implements UserService, UserDetailsService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtilities jwtService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Object> registerNewUser(UserCreateModel user) {
//        userRepo.save(
//                UserEntity.builder()
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .address(user.getAddress())
//                .email(user.getEmail())
//                .password(passwordEncoder.encode(user.getPassword()))
//                .role(user.getRole())
//                .build()
//        );
//

        UserEntity newUser = UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(user.getRole())
                .build();
        userRepo.save(newUser);

        UserAuthenticationResponse authResponse = UserAuthenticationResponse.builder()
                .token(jwtService.generateToken(newUser))
                .build();
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }
}
