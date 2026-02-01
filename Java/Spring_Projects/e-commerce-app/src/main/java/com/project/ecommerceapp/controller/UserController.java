package com.project.ecommerceapp.controller;


import com.project.ecommerceapp.dto.LoginRequest;
import com.project.ecommerceapp.dto.UserRequest;
import com.project.ecommerceapp.dto.UserResponse;
import com.project.ecommerceapp.entity.Role;
import com.project.ecommerceapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @PostMapping("/user")
    public UserResponse createUser(@RequestBody UserRequest userRequest){

        return userService.saveUser(userRequest);
    }

    @PostMapping("/user/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }

    @PatchMapping("/user/{id}")
    public UserResponse updateUser(@RequestBody UserRequest userRequest, @PathVariable(value = "id") Long id){
        return userService.updateUser(userRequest, id);
    }

    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable(value = "id") Long id){
        return userService.deleteById(id);
    }


}
