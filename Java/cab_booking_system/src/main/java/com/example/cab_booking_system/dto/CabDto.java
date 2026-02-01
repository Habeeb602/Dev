package com.example.cab_booking_system.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CabDto {

    @NotEmpty(message = "Cab driver name should not be empty")
    private String name;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should not be empty")
    private String mobileNumber;

    @NotNull
    private Boolean isAvailable;

    @NotNull
    private LocationDto locationDto;
}
