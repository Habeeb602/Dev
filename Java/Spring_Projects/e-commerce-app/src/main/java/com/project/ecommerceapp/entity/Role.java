package com.project.ecommerceapp.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="roles")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
}
