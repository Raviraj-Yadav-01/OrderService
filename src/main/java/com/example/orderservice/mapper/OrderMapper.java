package com.example.orderservice.mapper;


import com.example.orderservice.dto.CreateOrderResponseDTO;
import com.example.orderservice.dto.OrderRequestDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.enums.OrderStatus;


public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto){
          return Order.builder()
                  .userId(dto.getUserId())
                  .status(OrderStatus.PENDING)
                  .build();
    }

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order order){
        return CreateOrderResponseDTO.builder()
                .OrderId(order.getId())
                .status(order.getStatus())
                .build();
    }

}


