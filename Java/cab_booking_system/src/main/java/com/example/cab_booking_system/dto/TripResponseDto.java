package com.example.cab_booking_system.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class TripResponseDto {
    private Long id;
    private CustomerDto customerDto;
    private CabDto cabDto;
    private Double distance;
    private Double fare;
    private String status;
    private LocationDto sourceLocationDto;
    private LocationDto destinationLocationDto;
    private LocalDateTime tripStartTimestamp;
    private LocalDateTime tripEndTimestamp;

}
