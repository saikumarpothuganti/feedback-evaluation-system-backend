package com.feedback.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(
    @NotBlank(message = "fullName is required")
    String fullName,

    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    String email,

    @NotBlank(message = "username is required")
    String username,

    @NotBlank(message = "password is required")
    @Size(min = 6, message = "password must be at least 6 characters")
    String password,

    @NotBlank(message = "role is required")
    @Pattern(regexp = "student|faculty|admin", flags = Pattern.Flag.CASE_INSENSITIVE, message = "role must be student, faculty, or admin")
    String role
) {}