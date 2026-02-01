package com.example.cab_booking_system.service;

import com.example.cab_booking_system.dto.TripRequestDto;
import com.example.cab_booking_system.dto.TripResponseDto;
import com.example.cab_booking_system.entity.Cab;
import com.example.cab_booking_system.entity.Location;

public interface ITripService {
    TripResponseDto bookTrip(TripRequestDto tripDetailsDto);

    Cab searchNearestCab(Location location);

    double calculateEuclideanDistance(Location l1, Location l2);

    double calculateFare(double distance);

    double roundTo2Decimal(double number);

    void completeTrip(Long id);

    void cancelTrip(Long id);
}
