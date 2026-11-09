package com.hemanth.order.Entity;


import com.hemanth.order.enums.OrderStatus;
import com.hemanth.order.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
//@Data  (this will automatically create toString for entity class ,
////So If we print order it will print OrderItem and it will print Order again so it will cause StackOverFlow Error
////So use @Getter and @Setter in entity class
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1. Kafka & Microservices for everyorder there will be unique Id
    private String orderTrackingNumber;

    // 2. Financial Calculations
    private BigDecimal totalPrice;

    // 3. Status Tracking
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; //  PENDING, SHIPPED, DELIVERED

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus; //PENDING, SUCCESS, FAILED

    // 4. Auditing
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;
}
