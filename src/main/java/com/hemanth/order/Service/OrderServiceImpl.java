package com.hemanth.order.Service;

import com.hemanth.order.DTO.OrderItemRequestDTO;
import com.hemanth.order.DTO.OrderRequestDTO;
import com.hemanth.order.DTO.OrderResponseDTO;
import com.hemanth.order.Entity.Order;
import com.hemanth.order.Entity.OrderItem;
import com.hemanth.order.Entity.Product;
import com.hemanth.order.Mapper.OrderMapper;
import com.hemanth.order.Repository.OrderRepository;
import com.hemanth.order.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private  final OrderMapper orderMapper;
    private final ProductRepository productRepository;

    @Transactional
    @Override
    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO) {
        /*
        check productID
        check Quantity
        if itemRequestQuan > ProductQuatity -> throw not suffire
        if not update product StcokQuantity -item requested quantity
        then save product, then get the product details to order then sace order and return Order
         */
        Order order = new Order();
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        List<OrderItem> orderItemList = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;

        for(OrderItemRequestDTO item: orderRequestDTO.orderItems())
        {
            Product product = productRepository.findById(item.productID()).orElseThrow(() ->
                    new RuntimeException("Product Id not found" + item.productID())
            );
            if(product.getStockQuantity() < item.quantity())
            {
                throw new RuntimeException("Insuficeint stock for product" + product.getName());
            }
            product.setStockQuantity(product.getStockQuantity()-item.quantity());
            productRepository.save(product);

            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(item.quantity());
            orderItem.setProduct(product);
            orderItemList.add(orderItem);

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(item.quantity()));
            totalAmount = totalAmount.add(itemTotal);

        }
        order.setOrderItemList(orderItemList);
        order.setTotalPrice(totalAmount);
        orderRepository.save(order);

        return orderMapper.toResponseDTO(order);

    }
}
