package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Cart", uniqueConstraints = @UniqueConstraint(columnNames = { "CustID", "ProdID" }))
public class CartEntity extends BaseEntity {

//	    private int CartID;

	@Column(name = "customer_id", nullable = false)
	private int CustID;

	@Column(name = "product_id", nullable = false)
	private int ProdID;

	@Column(name = "quantity", nullable = false)
	private int Qty;

}
