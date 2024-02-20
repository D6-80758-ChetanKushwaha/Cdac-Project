package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cart_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString()
public class CartProductEntity extends BaseEntity {

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "order_id")
	// private OrderEntity order;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private CartEntity cart;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private ProductEntity product;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;
}
