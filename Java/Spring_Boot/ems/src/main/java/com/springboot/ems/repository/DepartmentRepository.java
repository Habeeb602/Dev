package com.springboot.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ems.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
