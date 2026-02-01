package com.example.cab_booking_system.entity;


import com.example.cab_booking_system.constants.TripStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long customerId;

    @Column
    private Long cabId;

    @Column
    private Double distance;

    @Column
    private Double fare;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

    @Column
    private Long sourceLocationId;

    @Column
    private Long destinationLocationId;

    @Column
    private LocalDateTime tripStartTimestamp;

    @Column
    private LocalDateTime tripEndTimestamp;
}

