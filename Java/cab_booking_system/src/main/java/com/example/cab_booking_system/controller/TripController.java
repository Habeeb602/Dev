package com.example.cab_booking_system.controller;


import com.example.cab_booking_system.dto.ResponseDto;
import com.example.cab_booking_system.dto.TripRequestDto;
import com.example.cab_booking_system.dto.TripResponseDto;
import com.example.cab_booking_system.service.ITripService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/trip", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TripController {

    private ITripService iTripService;

    @PostMapping("/book")
    public ResponseEntity<TripResponseDto> bookTrip(@RequestBody @Valid TripRequestDto tripRequestDto){

        TripResponseDto tripResponseDto = iTripService.bookTrip(tripRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tripResponseDto);
    }

    @PostMapping("/complete")
    public ResponseEntity<ResponseDto> completeTrip(@RequestParam @NotNull Long id){

        iTripService.completeTrip(id);


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Trip completed successfully"));
    }

    @PostMapping("/cancel")
    public ResponseEntity<ResponseDto> cancelTrip(@RequestParam @NotNull Long id){

        iTripService.cancelTrip(id);


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Trip cancelled successfully"));
    }
}
