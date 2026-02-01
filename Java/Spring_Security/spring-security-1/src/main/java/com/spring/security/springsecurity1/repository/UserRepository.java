package com.spring.security.springsecurity1.repository;

import com.spring.security.springsecurity1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Integer, User> {

    Optional<User> findByEmail(String email);
}
