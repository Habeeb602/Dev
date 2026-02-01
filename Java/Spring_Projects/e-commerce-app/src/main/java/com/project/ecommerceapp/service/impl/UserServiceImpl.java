package com.project.ecommerceapp.service.impl;

import com.project.ecommerceapp.dto.LoginRequest;
import com.project.ecommerceapp.dto.UserRequest;
import com.project.ecommerceapp.dto.UserResponse;
import com.project.ecommerceapp.entity.Role;
import com.project.ecommerceapp.entity.User;
import com.project.ecommerceapp.exception.UserNotFoundException;
import com.project.ecommerceapp.exception.WrongPasswordException;
import com.project.ecommerceapp.repository.RoleRepository;
import com.project.ecommerceapp.repository.UserRepository;
import com.project.ecommerceapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {

        User user = modelMapper.map(userRequest, User.class);
        Set<Role> roles = new HashSet<>();
        for(String name: userRequest.getRoles()){
            roles.add(roleRepository.findByName(name));
        }
        user.setRoles(roles);
        Long id = userRepository.save(user).getId();
        User savedUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found!"));
        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Override
    public List<UserResponse> findAll() {

        List<UserResponse> userResponses = userRepository.findAll().stream().map(this::mapToUserResponse).toList();

        return userResponses;
    }

    private UserResponse mapToUserResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found!"));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found!"));
        Optional.ofNullable(userRequest.getAddress()).ifPresent(user::setAddress);
        Optional.ofNullable(userRequest.getPassword()).ifPresent(user::setPassword);
        Optional.ofNullable(userRequest.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(userRequest.getPhone()).ifPresent(user::setPhone);
        Optional.ofNullable(userRequest.getUsername()).ifPresent(user::setUsername);

        if(userRequest.getRoles() != null){
            Set<Role> roles = new HashSet<>();
            for(String name: userRequest.getRoles()){
                roles.add(roleRepository.findByName(name));
            }
            user.setRoles(roles);
        }

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UserNotFoundException("There is no user with email: " + loginRequest.getEmail() + " present in the system!"));

        if(!user.getPassword().equals(loginRequest.getPassword())){
            throw new WrongPasswordException("The Password for ID: " + loginRequest.getEmail() + " is incorrect!");
        }

        return new ResponseEntity<>(modelMapper.map(user, UserResponse.class), HttpStatus.OK);

    }
}
