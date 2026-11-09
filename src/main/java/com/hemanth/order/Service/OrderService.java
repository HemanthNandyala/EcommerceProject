package com.hemanth.order.Service;

import com.hemanth.order.DTO.OrderRequestDTO;
import com.hemanth.order.DTO.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO);
}
