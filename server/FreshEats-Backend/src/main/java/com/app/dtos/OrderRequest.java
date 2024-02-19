package com.app.dtos;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    private LocalDateTime orderDate;

    private String shippingAddress;

    private PaymentMethodDTO paymentMethod;

    private Double totalPrice;

    private long customerId;

    private List<OrderProductDTO> products;
}
