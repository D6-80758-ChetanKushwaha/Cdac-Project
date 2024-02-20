package com.fresheats.fresh.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Order_Details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetailsEntity extends BaseEntity{

	 	@ManyToOne
	    @JoinColumn(name = "Order_ID", nullable = false)
	    private OrderEntity order; // Assuming you have an Order entity defined that maps to your Orders table

	    @ManyToOne
	    @JoinColumn(name = "Product_ID", nullable = false)
	    private ProductEntity product; // Assuming you have a Product entity defined that maps to your Products table

	    @Column(name = "Quantity", nullable = false)
	    private Integer quantity;

	    @Column(name = "Price_At_Purchase", nullable = false)
	    private Double priceAtPurchase;
}
