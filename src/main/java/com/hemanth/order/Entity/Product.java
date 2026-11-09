package com.hemanth.order.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import jakarta.validation.constraints.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Data (this will automatically create toString for entity class ,
//So If we print order it will print OrderItem and it will print Order again so it will cause StackOverFlow Error
//So use @Getter and @Setter in entity class
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  //  @NotBlank(message = "Sku is required")
    private String sku; // Stock Keeping Unit (ఉదాహరణకు: IPHONE-15-128GB)
  //  @NotBlank(message = "Product name is required")
    private String name;
    private String description;
 //   @Positive
  //  @Min(100)
    private BigDecimal price;
    private int stockQuantity;




}
