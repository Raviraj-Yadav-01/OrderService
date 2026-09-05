package com.example.orderservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderItemDTO {

    private Long productId;
    private int quantity;
}
