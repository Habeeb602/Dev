package com.example.cab_booking_system.service.impl;

import com.example.cab_booking_system.constants.TripStatus;
import com.example.cab_booking_system.dto.*;
import com.example.cab_booking_system.entity.*;
import com.example.cab_booking_system.exception.ResourceNotFoundException;
import com.example.cab_booking_system.mapper.CabMapper;
import com.example.cab_booking_system.mapper.CustomerMapper;
import com.example.cab_booking_system.mapper.LocationMapper;
import com.example.cab_booking_system.mapper.TripMapper;
import com.example.cab_booking_system.repository.CabRepository;
import com.example.cab_booking_system.repository.CustomerRepository;
import com.example.cab_booking_system.repository.LocationRepository;
import com.example.cab_booking_system.repository.TripRepository;
import com.example.cab_booking_system.service.ITripService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ITripServiceImpl implements ITripService {

    private CustomerRepository customerRepository;
    private CabRepository cabRepository;
    private LocationRepository locationRepository;
    private TripRepository tripRepository;

    @Override
    public TripResponseDto bookTrip(TripRequestDto tripDetailsDto) {


        // Fetching the customer
        Customer customer = customerRepository.findById(tripDetailsDto.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException(String.format("No customer found with the ID given: %d", tripDetailsDto.getCustomerId())));

        Location sourceLocation = LocationMapper.locationDtoToLocation(tripDetailsDto.getSourceLocation(), new Location());
        Location destinationLocation = LocationMapper.locationDtoToLocation(tripDetailsDto.getDestinationLocation(), new Location());

        // Fetching the nearest cab
        Cab cab = searchNearestCab(sourceLocation);
        Example<Location> example = Example.of(Location.builder().locationId(cab.getLocationId()).build());

        double distance = calculateEuclideanDistance(sourceLocation, destinationLocation);
        double fare = calculateFare(distance);

        sourceLocation = locationRepository.save(sourceLocation);
        destinationLocation = locationRepository.save(destinationLocation);

        Trip trip = Trip.builder()
                        .customerId(customer.getId())
                        .cabId(cab.getId())
                        .sourceLocationId(sourceLocation.getLocationId())
                        .destinationLocationId(destinationLocation.getLocationId())
                        .status(TripStatus.IN_PROGRESS)
                        .tripStartTimestamp(LocalDateTime.now())
                        .fare(fare)
                        .distance(distance)
                        .build();

        trip = tripRepository.save(trip);

        LocationDto cabLocationDto = LocationMapper.locationToLocationDto(locationRepository.findById(cab.getLocationId()).get(), new LocationDto());
        LocationDto customerLocationDto = LocationMapper.locationToLocationDto(locationRepository.findById(customer.getLocationId()).get(), new LocationDto());

        CabDto cabDto = CabMapper.cabToCabDto(cab, new CabDto());
        cabDto.setLocationDto(cabLocationDto);

        CustomerDto customerDto = CustomerMapper.customerToCustomerDto(customer, new CustomerDto());
        customerDto.setLocationDto(customerLocationDto);

        return TripMapper.tripToTripResponseDto(trip, cabDto, customerDto, sourceLocation, destinationLocation);
    }

    @Override
    public Cab searchNearestCab(Location location) {

        List<Cab> cabs = cabRepository.findByIsAvailableTrue();
        if(cabs.isEmpty())
            throw new ResourceNotFoundException(String.format("No cabs found near to your location -> lat: %d long: %d", location.getX(), location.getY()));

        List<Location> locations = locationRepository.findAllById(cabs.stream().map(Cab::getLocationId).collect(Collectors.toList()));
        Cab minDistCab = null;
        double minDist = Double.MAX_VALUE;
        double currCabDist;

        for (Cab cab : cabs) {
            Location loc = locations.stream().filter(l -> Objects.equals(l.getLocationId(), cab.getLocationId())).findFirst().get();
            currCabDist = calculateEuclideanDistance(location, loc);

            if(minDist > currCabDist){
                minDist = currCabDist;
                minDistCab = cab;
            }
        }

        if(minDist > 10)
            throw new ResourceNotFoundException(String.format("No cabs found within 10 KMs from your location -> lat: %d long: %d", location.getX(), location.getY()));

        return minDistCab;
    }

    @Override
    public double calculateEuclideanDistance(Location l1, Location l2) {
        double dist = Math.pow(l1.getX() - l2.getX() , 2) + Math.pow(l1.getY() - l2.getY() , 2);
        return roundTo2Decimal(Math.sqrt(dist));
    }

    @Override
    public double calculateFare(double distance) {
        double fare = 0;

        if(distance > 0 && distance <= 3){
            fare = 10 * distance;
        }
        else if(distance > 3 && distance <= 10){
            fare = 7 * distance;
        }
        else if(distance > 10 && distance <= 15){
            fare = 6 * distance;
        }
        else {
            fare = 5 * distance;
        }

        return roundTo2Decimal(fare);
    }

    @Override
    public double roundTo2Decimal(double number) {
        DecimalFormat format = new DecimalFormat("#.##");
        return Double.parseDouble(format.format(number));
    }

    @Override
    public void completeTrip(Long id) {
        int count = tripRepository.updateTrip(id, TripStatus.COMPLETED);

        if(count == 0)
            throw new ResourceNotFoundException("No trip found with the given id: " + id);
    }

    @Override
    public void cancelTrip(Long id) {
        int count = tripRepository.updateTrip(id, TripStatus.CANCELLED);
        if(count == 0)
            throw new ResourceNotFoundException("No trip found with the given id: " + id);
    }
}
