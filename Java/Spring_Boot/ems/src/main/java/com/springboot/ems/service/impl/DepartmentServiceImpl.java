package com.springboot.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ems.entity.Department;
import com.springboot.ems.repository.DepartmentRepository;
import com.springboot.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department) {
		
		return departmentRepository.save(department);
	
	}

	@Override
	public List<Department> getDepartments() {
		
		return departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department dept = departmentRepository.findById(id).get();
		dept.setName(department.getName());
		dept.setLocation(department.getLocation());
		return departmentRepository.save(dept);
	}

	@Override
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id).get();
	}
	
}
