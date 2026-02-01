package com.project.ecommerceapp.dto;


import com.project.ecommerceapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
    private List<String> roles;
}
