package com.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CartDTO {
	
	@JsonProperty(value = "cart_id",access = Access.READ_ONLY)
	private long id;
	
    private CustomerDTO customer;
    private CartStatusDTO cartStatus;
}
