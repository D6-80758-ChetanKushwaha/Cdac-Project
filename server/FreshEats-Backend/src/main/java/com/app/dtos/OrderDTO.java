package com.app.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.app.entities.OrderStatus;
import com.app.entities.PaymentStatus;
import com.app.entities.CustomerEntity;
import com.app.entities.OrderItemsEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString()
public class OrderDTO {

	@JsonProperty(value = "product_id",access = Access.READ_ONLY)
	private Long id;
	
	private CustomerEntity customer;
	 
    private List<OrderItemsEntity> items;
    
    private LocalDateTime orderDate;
    
    private Double totalPrice;

    private OrderStatus status; 

    private String paymentMethod;

    private String shippingAddress; 
    
    private PaymentStatus paymentStatus;
    
    

}
