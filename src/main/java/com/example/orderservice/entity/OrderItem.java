package com.example.orderservice.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

@Builder
public class OrderItem {


    private Long productId;

    private int quantity;

    private double pricePerUnit;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name ="order_id")
    private Order order;


}
