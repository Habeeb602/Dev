package com.microservices.departmentservice.service;

import com.microservices.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String departmentCode);

    List<DepartmentDto> findAll();
}
