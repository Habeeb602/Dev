package com.security.springsecuritybasics.repository;

import com.security.springsecuritybasics.entity.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttemptsRepository extends JpaRepository<Attempts, Long> {
    Optional<Attempts> findAttemptsByUsername(String username);
}
