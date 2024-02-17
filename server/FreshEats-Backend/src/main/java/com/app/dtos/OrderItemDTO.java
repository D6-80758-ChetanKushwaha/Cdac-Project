package com.app.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString()
public class OrderItemDTO {

		@JsonProperty(value = "product_id",access = Access.READ_ONLY)
		private Long id; 
		
	    private Long orderId;
	    
	    private Long productId;
	    
	    private int quantity;
	    
	    private BigDecimal unitPrice;
	    
	    private BigDecimal totalPrice;
}
