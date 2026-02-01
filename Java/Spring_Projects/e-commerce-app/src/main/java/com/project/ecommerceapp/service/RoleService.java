package com.project.ecommerceapp.service;

import com.project.ecommerceapp.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();
    Role findByName(String name);
    Role saveRole(Role role);
    Role updateRole(Role role, Long id);
    Boolean deleteById(Long id);
}
