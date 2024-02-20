package com.app.dtos;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString()
public class ProductDTO {

	@JsonProperty(value = "product_id", access = Access.READ_ONLY)
	private Long id;

	@NotNull(message = "Product category should not be null")
	private Long categoryId;

//	@NotNull
//	private Long sellerId;

	@NotBlank(message = "Product name should not be null")
	@Size(max = 25)
	private String name;

	@NotNull(message = "Product stock should not be null")
	@Positive
	private int stockQuantity;

	@NotBlank(message = "Product description should not be null")
	@Lob
	private String productDescription;

	@NotNull(message = "Product price should not be null")
	@Positive
	private double productPrice;

	@Positive
	private double discountedPrice;

	@Positive
	private double discountedPercent;

	@NotBlank(message = "Product image url should not be null")
	@URL // ensures that the imageUrl field contains a valid URL.
	@Size(max = 500)
	private String imageUrl;

}
