package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    // POST /orders
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Map<String, Object> payload) {
        String customerName = (String) payload.get("customerName");
        Double orderAmount = Double.parseDouble(payload.get("orderAmount").toString());
        String invoiceUrl = (String) payload.get("invoiceFileUrl");
        Order savedOrder = orderService.createOrder(customerName, orderAmount, invoiceUrl);
        return ResponseEntity.ok(savedOrder);
    }

    // GET /orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // GET /orders/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

}
