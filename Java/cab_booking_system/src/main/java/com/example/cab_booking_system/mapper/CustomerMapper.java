package com.example.cab_booking_system.mapper;

import com.example.cab_booking_system.dto.CustomerDto;
import com.example.cab_booking_system.entity.Customer;

public class CustomerMapper {

    public static Customer customerDtoToCustomer(CustomerDto customerDto, Customer customer){
        customer.setName(customerDto.getName());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

    public static CustomerDto customerToCustomerDto(Customer customer, CustomerDto customerDto){
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

}
