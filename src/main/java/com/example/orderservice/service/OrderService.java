package com.example.orderservice.service;


import com.example.orderservice.client.ProductServiceClient;
import com.example.orderservice.dto.CreateOrderResponseDTO;
import com.example.orderservice.dto.OrderItemDTO;
import com.example.orderservice.dto.OrderRequestDTO;
import com.example.orderservice.dto.ProductDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderItem;
import com.example.orderservice.mapper.OrderItemMapper;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class OrderService implements IOrderService {


    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public OrderService(OrderRepository orderRepository, ProductServiceClient productServiceClient){
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }


    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request) {
       Order order = OrderMapper.toEntity(request);

       List<OrderItem> items = new ArrayList<>();


       for(OrderItemDTO itemDTO : request.getItems()){

           ProductDTO product = productServiceClient.getProductById(itemDTO.getProductId());
           double pricePerUnit = product.getPrice();
           double totalPrice = pricePerUnit * itemDTO.getQuantity();

           OrderItem item = OrderItemMapper.orderItemRequestDTOtoOrderItemEntity(
                   itemDTO,
                   order,
                   pricePerUnit,
                   totalPrice
           );
           items.add(item);
       }
         order.setItems(items);
         Order createdOrder = orderRepository.save(order);
         return OrderMapper.toCreateOrderResponseDTO(createdOrder);

    }


}

