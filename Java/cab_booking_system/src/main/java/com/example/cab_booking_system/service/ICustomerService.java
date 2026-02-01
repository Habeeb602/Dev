package com.example.cab_booking_system.service;

import com.example.cab_booking_system.dto.CustomerDto;
import com.example.cab_booking_system.dto.CustomerTripResponseDto;

import java.util.List;

public interface ICustomerService {

    void createCustomer(CustomerDto customerDto);

    CustomerTripResponseDto fetchBookings(long customerId);
}
