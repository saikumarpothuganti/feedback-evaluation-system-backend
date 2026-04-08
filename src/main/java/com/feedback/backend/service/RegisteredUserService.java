package com.feedback.backend.service;

import com.feedback.backend.dto.RegisterUserRequest;
import com.feedback.backend.entity.RegisteredUser;
import com.feedback.backend.repository.RegisteredUserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserService {

    private final RegisteredUserRepository registeredUserRepository;

    public RegisteredUserService(RegisteredUserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    public RegisteredUser register(RegisterUserRequest request) {
        if (registeredUserRepository.existsByUsernameIgnoreCase(request.username())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (registeredUserRepository.existsByEmailIgnoreCase(request.email())) {
            throw new IllegalArgumentException("Email already exists");
        }

        RegisteredUser user = new RegisteredUser();
        user.setFullName(request.fullName().trim());
        user.setEmail(request.email().trim().toLowerCase());
        user.setUsername(request.username().trim());
        user.setPassword(request.password());
        user.setRole(request.role().trim().toLowerCase());

        return registeredUserRepository.save(user);
    }

    public List<RegisteredUser> getAllUsers() {
        return registeredUserRepository.findAll();
    }
}