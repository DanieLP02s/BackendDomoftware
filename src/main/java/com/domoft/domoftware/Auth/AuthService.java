package com.domoft.domoftware.Auth;

import com.domoft.domoftware.Jwt.JwtService;
import com.domoft.domoftware.Module.Role.Role;
import com.domoft.domoftware.Module.User.User;
import com.domoft.domoftware.Module.User.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        logger.info("Attempting login for user: {}", request.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            UserDetails user = userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            String token = jwtService.getToken(user);
            logger.info("Login successful for user: {}", request.getUsername());
            return AuthResponse.builder()
                    .token(token)
                    .message("Autenticación exitosa")
                    .user((User) user)
                    .build();
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for user: {}", request.getUsername(), e);
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }

    public AuthResponse register(RegisterRequest request) {
        logger.info("Attempting to register new user: {}", request.getUsername());
        try {
            if (userRepository.findByUsername(request.getUsername()).isPresent()) {
                logger.warn("Registration failed: Username already exists: {}", request.getUsername());
                throw new RuntimeException("Username already exists");
            }

            String defaultImageUrl = "https://cdn-icons-png.flaticon.com/512/149/149071.png";
            String imageUrl = (request.getImageUrl() == null || request.getImageUrl().isEmpty())
                    ? defaultImageUrl : request.getImageUrl();

            User user = User.builder()
                    .name(request.getName())
                    .lastName(request.getLastName())
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .imageUrl(imageUrl)
                    .title(request.getTitle())
                    .bio(request.getBio())
                    .phone(request.getPhone())
                    .address(request.getAddress())
                    .preferredLanguage(request.getPreferredLanguage())
                    .notificationPreferences(request.getNotificationPreferences())
                    .createdAt(new Timestamp(new Date().getTime()))
                    .role(Role.USER)
                    .build();

            userRepository.save(user);

            String token = jwtService.getToken(user);
            logger.info("Registration successful for user: {}", request.getUsername());
            return AuthResponse.builder()
                    .message("Registro exitoso")
                    .user(user)
                    .token(token)
                    .build();
        } catch (Exception e) {
            logger.error("Registration failed for user: {}", request.getUsername(), e);
            throw new RuntimeException("Registration failed: " + e.getMessage());
        }
    }
}