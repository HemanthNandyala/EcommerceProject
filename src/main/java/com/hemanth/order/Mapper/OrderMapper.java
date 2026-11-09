package com.hemanth.order.Mapper;

import com.hemanth.order.DTO.OrderRequestDTO;
import com.hemanth.order.DTO.OrderResponseDTO;
import com.hemanth.order.Entity.Order;


public interface OrderMapper {

   Order toEntity(OrderRequestDTO orderRequestDTO);

   OrderResponseDTO toResponseDTO(Order order);
}
