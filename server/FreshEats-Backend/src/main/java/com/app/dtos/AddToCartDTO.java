package com.app.dtos;

import com.app.entities.CartEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString()
public class AddToCartDTO {
	
	private Long custId;

	private Long prodId;

	private Integer qty;

	private double price;
}
