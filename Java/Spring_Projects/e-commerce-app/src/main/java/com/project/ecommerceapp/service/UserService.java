package com.project.ecommerceapp.service;


import com.project.ecommerceapp.dto.LoginRequest;
import com.project.ecommerceapp.dto.UserRequest;
import com.project.ecommerceapp.dto.UserResponse;
import com.project.ecommerceapp.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserRequest user);
    List<UserResponse> findAll();
    UserResponse findById(Long id);
    UserResponse updateUser(UserRequest userRequest, Long id);
    Boolean deleteById(Long id);

    ResponseEntity<UserResponse> loginUser(LoginRequest loginRequest);
}
