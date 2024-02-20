package com.app.entities;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sellers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
//@Audited
public class SellerEntity extends BaseEntity{
	
	@Column(name = "first_name",length = 45,  nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 45,  nullable = false)
	private String lastName;
	
	@Column(name = "email", length = 45,  nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "contact", length = 10,  nullable = false)
    private String contactInfo;
	
	@Column(name = "address", length = 50,  nullable = false)
	private String address;
    
    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
    private SellerStatus status;

    @Enumerated(EnumType.STRING)
    private Role role;

    
    
}
