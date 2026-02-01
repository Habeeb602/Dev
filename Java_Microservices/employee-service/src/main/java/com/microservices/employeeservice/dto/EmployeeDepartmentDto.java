package com.microservices.employeeservice.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDepartmentDto {
    private EmployeeDto employee;
    private DepartmentDto department;
}
