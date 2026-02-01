package com.project.ecommerceapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartItem {

    @Id
    private String uuid;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Long quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
