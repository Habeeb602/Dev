package com.example.cab_booking_system.repository;

import com.example.cab_booking_system.constants.TripStatus;
import com.example.cab_booking_system.entity.Trip;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TripRepository extends JpaRepository<Trip, Long> {

    @Modifying
    @Transactional
    @Query("update Trip set status=:status where id=:id")
    int updateTrip(@Param("id") Long id, @Param("status") TripStatus status);
}
