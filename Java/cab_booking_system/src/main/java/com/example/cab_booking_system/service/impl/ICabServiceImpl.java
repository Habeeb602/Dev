package com.example.cab_booking_system.service.impl;

import com.example.cab_booking_system.dto.CabDto;
import com.example.cab_booking_system.dto.LocationDto;
import com.example.cab_booking_system.entity.Cab;
import com.example.cab_booking_system.entity.Location;
import com.example.cab_booking_system.exception.ResourceNotFoundException;
import com.example.cab_booking_system.mapper.CabMapper;
import com.example.cab_booking_system.mapper.LocationMapper;
import com.example.cab_booking_system.repository.CabRepository;
import com.example.cab_booking_system.repository.LocationRepository;
import com.example.cab_booking_system.service.ICabService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ICabServiceImpl implements ICabService {

    private CabRepository cabRepository;
    private LocationRepository locationRepository;

    @Override
    public boolean createCab(CabDto cabDto) {

        try{
            Location location = locationRepository.save(LocationMapper.locationDtoToLocation(
                    cabDto.getLocationDto(),new Location()
            ));

            Cab cab = CabMapper.cabDtoToCab(cabDto, new Cab());
            cab.setLocationId(location.getLocationId());
            cab = cabRepository.save(cab);

            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateCabLocation(Long id, LocationDto locationDto) {

        Cab cab = cabRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No cab found with given id: %d", id)));

        Location location = locationRepository
                        .findById(cab.getLocationId())
                                .orElseThrow(() -> new ResourceNotFoundException(String.format("No location found with the id: %d", cab.getLocationId())));


        LocationMapper.locationDtoToLocation(locationDto, location);

        locationRepository.save(location);

        return true;
    }

    @Override
    public void updateCabAvailability(Long id, Boolean isAvailable) {
        Cab cab = cabRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No cab found with given id: %d", id)));
        cab.setIsAvailable(isAvailable);

        cabRepository.save(cab);
    }

    @Override
    public List<CabDto> getAllCabs() {
        List<Cab> cabs = cabRepository.findAll();
        List<CabDto> cabDtos = new ArrayList<>();

        cabs.forEach((cab) -> {
            CabDto cabDto = CabMapper.cabToCabDto(cab, new CabDto());
            Location location = locationRepository.findById(cab.getLocationId()).get();
            LocationDto locationDto = LocationMapper.locationToLocationDto(location, new LocationDto());
            cabDto.setLocationDto(locationDto);
            cabDtos.add(cabDto);
        });

        return cabDtos;
    }
}
