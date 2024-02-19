package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.app.repositories.CartProductRepository;
import com.app.repositories.CartRepository;
import com.app.repositories.CustomerRepository;
import com.app.repositories.ProductRepository;
import com.app.services.CartServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "cart")
public class CartEntity extends BaseEntity {

	

	//card_id, customer_id, status (ACTIVE, INACTIVE)

		@ManyToOne
		@PrimaryKeyJoinColumn
		private CustomerEntity customer;

		@Enumerated(EnumType.STRING)
		@Column(name = "status")
		private CartStatus cartStatus;

}
