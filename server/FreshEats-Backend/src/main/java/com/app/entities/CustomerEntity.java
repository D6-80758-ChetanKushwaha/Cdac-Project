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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "secure_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password") // toString excluding password
public class CustomerEntity extends BaseEntity {
	
	//Bi-directional --> access all orders for a customer (from the Customer side) and to access the customer from an Order.
	@OneToMany(mappedBy = "customer",  cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderEntity> orders ;
	
	//Uni-directional
//	 @OneToOne(cascade = CascadeType.ALL)
//	 @JoinColumn(name = "cart_id", referencedColumnName = "id")
//	 private CartEntity cart;
	 
	@Column(length = 20)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

	@Column(length = 30, nullable = false, unique = true)
	private String email;
	
	@Column(length = 300, nullable = false)
	private String password;
	
	@Column(name = "address", length = 50,  nullable = false)
	private String address;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
	
	@Column(name = "CreatedAt")
	private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

}




