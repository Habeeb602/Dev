package com.example.cab_booking_system.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerTripResponseDto {
    private CustomerDto customerDto;
    private List<TripResponseDto> tripResponseDtos;
}
