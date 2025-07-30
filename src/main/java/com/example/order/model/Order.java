package com.example.order.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String orderId;
    private String customerName;
    private Double orderAmount;
    private Instant orderDate;
    private String invoiceFileUrl;

    public Order(UUID uuid, String sampleCustomer, double v, Instant now, String url) {
    }
}
