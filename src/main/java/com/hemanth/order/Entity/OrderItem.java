package com.hemanth.order.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
//@Data(this will automatically create toString for entity class ,
//So If we print order it will print OrderItem and it will print Order again so it will cause StackOverFlow Error
//So use @Getter and @Setter in entity class
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
