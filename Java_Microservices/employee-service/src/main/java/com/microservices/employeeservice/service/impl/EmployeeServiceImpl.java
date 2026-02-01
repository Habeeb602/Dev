package com.microservices.employeeservice.service.impl;

import com.microservices.employeeservice.dto.DepartmentDto;
import com.microservices.employeeservice.dto.EmployeeDepartmentDto;
import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.exception.EmployeeNotFoundException;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    private final OpenFeignAPIClient openFeignAPIClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

//        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);


//        return new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getEmail());
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDepartmentDto findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isEmpty()){
            throw new EmployeeNotFoundException("No Employee found with the ID: " + id);
        }

        // RestTemplate
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity =  restTemplate.getForEntity("http://localhost:8079/api/department/" + employee.get().getDepartmentCode(), DepartmentDto.class);

        /*
        DepartmentDto departmentDtoResponse = webClient.get()
                .uri("http://localhost:8079/api/department/" + employee.get().getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
         */


        EmployeeDto employeeDto = modelMapper.map(employee.get(), EmployeeDto.class);
//        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();
        DepartmentDto departmentDtoResponse = openFeignAPIClient.getDepartmentByCode(employeeDto.getDepartmentCode());


        return EmployeeDepartmentDto.builder().employee(employeeDto).department(departmentDtoResponse).build();
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employeesList = employeeRepository.findAll();

        return employeesList.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }
}
