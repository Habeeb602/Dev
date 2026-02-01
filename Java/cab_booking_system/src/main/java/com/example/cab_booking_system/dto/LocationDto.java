package com.example.cab_booking_system.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LocationDto {
    @NotEmpty
    private Integer x;
    @NotEmpty
    private Integer y;
}
