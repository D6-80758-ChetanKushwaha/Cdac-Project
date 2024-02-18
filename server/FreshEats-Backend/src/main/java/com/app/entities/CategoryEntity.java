package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "category")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryEntity extends BaseEntity {

	// a category can contain multiple products.
	// "Fruits" and "Organic" each have a recategoryserviceference to the "Apple"
	// product.
	@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<ProductEntity> products;

	@Column(name = "category_name", nullable = false)
	private String categoryName;

	@Column(name = "description")
	private String description;

}
