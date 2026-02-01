package com.project.ecommerceapp.dto;

import com.project.ecommerceapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
//    private String password;
    private String phone;
    private String address;
    private Set<Role> roles;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
}
