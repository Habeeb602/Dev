package com.example.cab_booking_system.service;

import com.example.cab_booking_system.dto.CabDto;
import com.example.cab_booking_system.dto.LocationDto;

import java.util.List;

public interface ICabService {
    boolean createCab(CabDto cabDto);
    boolean updateCabLocation(Long id, LocationDto locationDto);
    void updateCabAvailability(Long id, Boolean isAvailable);
    List<CabDto> getAllCabs();
}
