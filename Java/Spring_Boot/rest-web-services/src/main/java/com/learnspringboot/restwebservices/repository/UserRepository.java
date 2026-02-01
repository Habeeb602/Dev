package com.learnspringboot.restwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspringboot.restwebservices.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
