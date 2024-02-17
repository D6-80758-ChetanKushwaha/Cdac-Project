package com.app.dtos;

import java.util.List;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.app.entities.ProductEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString()
public class CategoryDTO {
	
	@JsonProperty(value = "product_id",access = Access.READ_ONLY)
	private Long id;

	//private Long productId;
	
	@NotBlank(message = "Category name should not be null")
	@Size(max = 25)
	private String categoryName;

	@NotBlank(message = "Category description should not be null")
	@Lob
	private String description;
}
