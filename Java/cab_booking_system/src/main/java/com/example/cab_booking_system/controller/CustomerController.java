package com.example.cab_booking_system.controller;


import com.example.cab_booking_system.dto.CustomerDto;
import com.example.cab_booking_system.dto.CustomerTripResponseDto;
import com.example.cab_booking_system.dto.ResponseDto;
import com.example.cab_booking_system.service.ICustomerService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CustomerController {

    private ICustomerService iCustomerService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerDto customerDto){

        iCustomerService.createCustomer(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED,"Customer created successfully"));
    }

    @GetMapping("/fetchAllBookings")
    public ResponseEntity<CustomerTripResponseDto> fetchAllBookings(@RequestParam @NotNull long customerId){


        CustomerTripResponseDto customerTripResponseDto = iCustomerService.fetchBookings(customerId);


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerTripResponseDto);
    }
}
