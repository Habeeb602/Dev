package com.springboot.ems.service;

import java.util.List;

import com.springboot.ems.entity.Department;

public interface DepartmentService {
	Department addDepartment(Department department);
	List<Department> getDepartments();
	Department getDepartmentById(Long id);
	Department updateDepartment(Long id, Department department);
	void deleteDepartment(Long id);
}
