package com.learnspringboot.restwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspringboot.restwebservices.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
