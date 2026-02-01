package com.springboot.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.ems.entity.Employee;

@Service
public interface EmployeeService {
	List<Employee> getEmployees();
	Employee getEmployeeById(Long id);
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Long id, Employee employee);
	void deleteEmployee(Long id);
}
