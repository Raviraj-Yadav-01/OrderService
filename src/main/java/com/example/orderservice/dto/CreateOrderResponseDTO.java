package com.example.orderservice.dto;

import com.example.orderservice.enums.OrderStatus;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateOrderResponseDTO {

    private Long OrderId;
    private OrderStatus status;
}
