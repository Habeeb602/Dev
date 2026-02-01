package com.project.ecommerceapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private LocalDateTime created_at = LocalDateTime.now();
    @Column
    private LocalDateTime modified_at = LocalDateTime.now();
}
