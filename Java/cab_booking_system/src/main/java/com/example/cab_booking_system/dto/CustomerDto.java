package com.example.cab_booking_system.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty
    private String name;
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should not be empty")
    private String mobileNumber;
    @NotEmpty
    private LocationDto locationDto;
}
