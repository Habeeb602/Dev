package com.example.cab_booking_system.service.impl;

import com.example.cab_booking_system.dto.*;
import com.example.cab_booking_system.entity.Cab;
import com.example.cab_booking_system.entity.Customer;
import com.example.cab_booking_system.entity.Location;
import com.example.cab_booking_system.entity.Trip;
import com.example.cab_booking_system.exception.ResourceNotFoundException;
import com.example.cab_booking_system.mapper.CabMapper;
import com.example.cab_booking_system.mapper.CustomerMapper;
import com.example.cab_booking_system.mapper.LocationMapper;
import com.example.cab_booking_system.mapper.TripMapper;
import com.example.cab_booking_system.repository.CabRepository;
import com.example.cab_booking_system.repository.CustomerRepository;
import com.example.cab_booking_system.repository.LocationRepository;
import com.example.cab_booking_system.repository.TripRepository;
import com.example.cab_booking_system.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ICustomerServiceImpl implements ICustomerService {

    private LocationRepository locationRepository;
    private CustomerRepository customerRepository;
    private TripRepository tripRepository;
    private CabRepository cabRepository;

    @Override
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.customerDtoToCustomer(customerDto, new Customer());
        Location location = LocationMapper.locationDtoToLocation(customerDto.getLocationDto(), new Location());

        location = locationRepository.save(location);
        customer.setLocationId(location.getLocationId());
        customerRepository.save(customer);
    }

    @Override
    public CustomerTripResponseDto fetchBookings(long customerId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("No Customer found with the given id: %d", customerId))
        );

        CustomerDto customerDto = CustomerMapper.customerToCustomerDto(customer, new CustomerDto());

        Example<Trip> example = Example.of(Trip.builder().customerId(customerId).build());
        List<Trip> trips = tripRepository.findAll(example, Sort.by(Sort.Direction.ASC, "cabId"));

        List<TripResponseDto> tripResponseDtos = new ArrayList<>();

        for(Trip trip: trips){

            CabDto cabDto = CabMapper.cabToCabDto(cabRepository.findById(trip.getCabId()).get(), new CabDto());
            Location sourceLocation = locationRepository.findById(trip.getSourceLocationId()).get();
            Location destinationLocation = locationRepository.findById(trip.getDestinationLocationId()).get();

            TripResponseDto tripResponseDto = TripMapper.tripToTripResponseDto(trip, cabDto, null, sourceLocation, destinationLocation);
            tripResponseDtos.add(tripResponseDto);
        }


        return CustomerTripResponseDto.builder()
                .customerDto(customerDto)
                .tripResponseDtos(tripResponseDtos)
                .build();
    }
}
