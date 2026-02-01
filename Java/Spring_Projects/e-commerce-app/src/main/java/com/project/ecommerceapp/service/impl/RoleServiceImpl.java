package com.project.ecommerceapp.service.impl;

import com.project.ecommerceapp.entity.Role;
import com.project.ecommerceapp.exception.UserNotFoundException;
import com.project.ecommerceapp.repository.RoleRepository;
import com.project.ecommerceapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role, Long id) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        roleRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Role with ID: " + id + " not present!"));
        roleRepository.deleteById(id);
        return true;
    }
}
