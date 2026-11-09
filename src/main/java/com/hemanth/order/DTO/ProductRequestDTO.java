package com.hemanth.order.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "Sku is required")
        String sku, // Stock Keeping Unit (ఉదాహరణకు: IPHONE-15-128GB)
        @NotBlank(message = "Product name is required")
        String name,
        String description,
        @Positive
        @Min(100) BigDecimal price,
        int stockQuantity
)

{
}
