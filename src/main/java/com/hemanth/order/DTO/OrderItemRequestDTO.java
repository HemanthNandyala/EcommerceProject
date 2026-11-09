package com.hemanth.order.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemRequestDTO(
        @NotNull(message="Product Id is required")
        Long productID,
        @Positive(message = "Quantity must be greater than zero")
        int quantity) {

}
