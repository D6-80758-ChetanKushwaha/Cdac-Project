package com.app.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
@Getter
@Setter
@ToString()
public class OrderItemsEntity extends BaseEntity{

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "order_id")
	  private OrderEntity order;
	    
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "product_id")
	   private ProductEntity product;
	    
	  private int quantity;
	    
	  @Column(name = "unit_price")
	  private BigDecimal unitPrice;
	    
	  @Column(name = "total_price")
	  private BigDecimal totalPrice;
}
