package com.microservices.departmentservice.service.impl;

import com.microservices.departmentservice.dto.DepartmentDto;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.exception.DepartmentNotFoundException;
import com.microservices.departmentservice.repository.DepartmentRepository;
import com.microservices.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

//        Department department = new Department(departmentDto.getId(), departmentDto.getDepartmentName(), departmentDto.getDepartmentCode(), departmentDto.getDepartmentDescription());

        Department department = modelMapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);


//        return new DepartmentDto(savedDepartment.getId(), savedDepartment.getDepartmentName(), savedDepartment.getDepartmentCode(), savedDepartment.getDepartmentDescription());
        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department;
        try{
             department = departmentRepository.getByDepartmentCode(departmentCode);
        }
        catch(Exception ex){
            throw new DepartmentNotFoundException("No Department found with the code: " + departmentCode);
        }

//        return new DepartmentDto(department.getId(), department.getDepartmentName(), department.getDepartmentCode(), department.getDepartmentDescription());
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> findAll() {
        List<Department> departmentList = departmentRepository.findAll();

        return departmentList.stream().map(department -> modelMapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
    }
}
