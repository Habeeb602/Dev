package com.example.cab_booking_system.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cab extends Person{

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "is_available")
    private Boolean isAvailable;
}
