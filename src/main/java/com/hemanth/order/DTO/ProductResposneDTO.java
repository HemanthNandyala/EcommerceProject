package com.hemanth.order.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductResposneDTO(

        Long id,
        @NotBlank(message = "Sku is required")
        String sku, // Stock Keeping Unit (ఉదాహరణకు: IPHONE-15-128GB)
        @NotBlank(message = "Product name is required")
        String name,
        String description,
        @Positive
        @Min(100) BigDecimal price,
        int stockQuantity
) {
}
