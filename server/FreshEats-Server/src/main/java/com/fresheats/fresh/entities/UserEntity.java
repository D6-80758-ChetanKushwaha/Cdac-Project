package com.fresheats.fresh.entities;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password") // toString excluding password
public class UserEntity extends BaseEntity {

	@Column(length = 20)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

	@Column(length = 30, nullable = false, unique = true)
	private String email;
	
	@Column(length = 30, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
	
	@Column(name = "Created_At", nullable = false)
	private LocalDateTime createdAt;

    @Column(name = "Updated_At")
    private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "user")
	private List<OrderEntity> orderId;

}




