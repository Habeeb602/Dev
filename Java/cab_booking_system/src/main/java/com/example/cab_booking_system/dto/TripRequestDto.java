package com.example.cab_booking_system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TripRequestDto {
    @NotNull
    private Long customerId;
    @NotNull
    private LocationDto sourceLocation;
    @NotNull
    private LocationDto destinationLocation;
}
