package com.example.cab_booking_system.mapper;

import com.example.cab_booking_system.dto.CabDto;
import com.example.cab_booking_system.entity.Cab;

public class CabMapper {

    public static Cab cabDtoToCab(CabDto cabDto, Cab cab){
        cab.setName(cabDto.getName());
        cab.setIsAvailable(cabDto.getIsAvailable());
        cab.setMobileNumber(cabDto.getMobileNumber());
        return cab;
    }

    public static CabDto cabToCabDto(Cab cab, CabDto cabDto){
        cabDto.setName(cab.getName());
        cabDto.setIsAvailable(cab.getIsAvailable());
        cabDto.setMobileNumber(cab.getMobileNumber());
        return cabDto;
    }

}
