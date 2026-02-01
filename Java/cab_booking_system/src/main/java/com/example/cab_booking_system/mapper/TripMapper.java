package com.example.cab_booking_system.mapper;

import com.example.cab_booking_system.dto.CabDto;
import com.example.cab_booking_system.dto.CustomerDto;
import com.example.cab_booking_system.dto.LocationDto;
import com.example.cab_booking_system.dto.TripResponseDto;
import com.example.cab_booking_system.entity.Cab;
import com.example.cab_booking_system.entity.Customer;
import com.example.cab_booking_system.entity.Location;
import com.example.cab_booking_system.entity.Trip;

public class TripMapper {

    public static TripResponseDto tripToTripResponseDto(Trip trip, CabDto cabDto, CustomerDto customerDto, Location sourceLocation, Location destiationLocation){


        LocationDto sourceLocationDto = LocationMapper.locationToLocationDto(sourceLocation, new LocationDto());
        LocationDto destiationLocationDto = LocationMapper.locationToLocationDto(destiationLocation, new LocationDto());

        LocationDto driverLocation = LocationMapper.locationToLocationDto(destiationLocation, new LocationDto());


        TripResponseDto tripResponseDto = TripResponseDto.builder()
                .cabDto(cabDto)
                .customerDto(customerDto)
                .id(trip.getId())
                .sourceLocationDto(sourceLocationDto)
                .destinationLocationDto(destiationLocationDto)
                .tripStartTimestamp(trip.getTripStartTimestamp())
                .fare(trip.getFare())
                .distance(trip.getDistance())
                .status(trip.getStatus().toString())
                .build();

        return tripResponseDto;
    }
}
