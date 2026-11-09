package com.hemanth.order.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record OrderRequestDTO(
        @NotEmpty(message = "Order must not be empty")
        @Valid
        List<OrderItemRequestDTO>  orderItems
) {
}
