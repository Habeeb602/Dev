package com.example.cab_booking_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@Builder
public class ErrorResponseDto {
    private String path;
    private HttpStatus httpStatus;
    private String message;
}
