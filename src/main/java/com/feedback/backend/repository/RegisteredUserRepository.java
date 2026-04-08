package com.feedback.backend.repository;

import com.feedback.backend.entity.RegisteredUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
    boolean existsByUsernameIgnoreCase(String username);

    boolean existsByEmailIgnoreCase(String email);

    Optional<RegisteredUser> findByUsernameIgnoreCase(String username);
}