package com.example.cab_booking_system.mapper;

import com.example.cab_booking_system.dto.LocationDto;
import com.example.cab_booking_system.entity.Location;

public class LocationMapper {

    public static Location locationDtoToLocation(LocationDto locationDto, Location location){
        location.setX(locationDto.getX());
        location.setY(locationDto.getY());
        return location;
    }

    public static LocationDto locationToLocationDto(Location location, LocationDto locationDto){
        locationDto.setX(location.getX());
        locationDto.setY(location.getY());
        return locationDto;
    }

}
