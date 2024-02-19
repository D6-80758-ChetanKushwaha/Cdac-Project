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
public class CartItemDTO {

		@JsonProperty(value = "cartitem_id",access = Access.READ_ONLY)
		private Long id; 
	    
	    private Long productId;
	    
	    private String productName;
	    
	    private int quantity;
	    
	    
}
