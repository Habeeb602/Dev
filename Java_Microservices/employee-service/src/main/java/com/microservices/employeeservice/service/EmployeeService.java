package com.microservices.employeeservice.service;

import com.microservices.employeeservice.dto.EmployeeDepartmentDto;
import com.microservices.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDepartmentDto findById(Long id);

    List<EmployeeDto> getEmployees();
}
