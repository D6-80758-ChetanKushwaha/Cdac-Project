package com.app.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString()
public class OrderEntity extends BaseEntity{
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer; // Assuming you have a User entity defined that maps to your Users table

//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//   private List<OrderItemsEntity> items = new ArrayList<>();
	
//    @Column(name = "total_price", nullable = false)
//    private Double totalPrice;
	
	 @Column(name = "order_date")
	 private LocalDateTime orderDate;
	 
	 @Column(name = "shipping_address")
	    @Lob
	    private String shippingAddress; 

	 @Column(name = "payment_method", nullable = false)
	 	private String paymentMethod;
	 
	   @Enumerated(EnumType.STRING)
	    @Column(name = "payment_status")
	    private PaymentStatus paymentStatus;
	
	 @Enumerated(EnumType.STRING)
	 @Column(name = "status", nullable = false)
	 	private OrderStatus status; 


   
}
