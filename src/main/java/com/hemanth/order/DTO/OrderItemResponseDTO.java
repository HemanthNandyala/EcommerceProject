package com.hemanth.order.DTO;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record OrderItemResponseDTO(
        int quantity,
        BigDecimal price,
        String sku
) {
}
