package com.example.cab_booking_system.controller;

import com.example.cab_booking_system.dto.CabDto;
import com.example.cab_booking_system.dto.LocationDto;
import com.example.cab_booking_system.dto.ResponseDto;
import com.example.cab_booking_system.service.ICabService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cab", produces = MediaType.APPLICATION_JSON_VALUE)
@NoArgsConstructor
public class CabController {

    @Autowired
    private ICabService iCabService;
    private Logger log = LoggerFactory.getLogger(CabController.class);

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCab(@RequestBody @Valid CabDto cabDto){

//        log.info("CabDto: " + cabDto);

        return iCabService.createCab(cabDto) ?
                ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED, "Cab created successfully")) :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong, please check the logs."));
    }

    @PostMapping("/updateCabLocation")
    public ResponseEntity<ResponseDto> updateCabLocation(@RequestParam @NotNull Long id,
                                                         @RequestBody @Valid LocationDto locationDto){

        return iCabService.updateCabLocation(id, locationDto) ?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK, "Cab location updated successfully")) :
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong, please check the logs."));
    }

    @PostMapping("/updateCabAvailability")
    public ResponseEntity<ResponseDto> updateCabAvailability(@RequestParam @NotNull Long id,
                                                         @RequestParam @NotNull Boolean isAvailable){

        iCabService.updateCabAvailability(id, isAvailable);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK, "Cab Availability updated successfully"));
    }



    @GetMapping("/list")
    public ResponseEntity<List<CabDto>> getAllCabs(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(iCabService.getAllCabs());
    }


}
