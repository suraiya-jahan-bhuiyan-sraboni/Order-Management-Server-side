package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder(String customerName, Double orderAmount, String invoiceUrl) {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setCustomerName(customerName);
        order.setOrderAmount(orderAmount);
        order.setOrderDate(Instant.parse(Instant.now().toString()));
        order.setInvoiceFileUrl(invoiceUrl);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findByOrderId(id);
    }

}
