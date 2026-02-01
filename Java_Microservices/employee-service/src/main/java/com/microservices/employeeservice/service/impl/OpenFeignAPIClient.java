package com.microservices.employeeservice.service.impl;


import com.microservices.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface OpenFeignAPIClient {

    @GetMapping("/api/department/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String code);
}
