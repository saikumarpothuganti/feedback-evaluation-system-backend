package com.feedback.backend.controller;

import com.feedback.backend.dto.ApiResponse;
import com.feedback.backend.dto.RegisterUserRequest;
import com.feedback.backend.entity.RegisteredUser;
import com.feedback.backend.service.RegisteredUserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class RegisteredUserController {

    private final RegisteredUserService registeredUserService;

    public RegisteredUserController(RegisteredUserService registeredUserService) {
        this.registeredUserService = registeredUserService;
    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserRequest request) {
        try {
            RegisteredUser saved = registeredUserService.register(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "message", "User registered successfully",
                "user", saved
            ));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                "message", ex.getMessage(),
                "timestamp", java.time.Instant.now()
            ));
        }
    }

    @GetMapping
    public ResponseEntity<List<RegisteredUser>> getAll() {
        return ResponseEntity.ok(registeredUserService.getAllUsers());
    }
}