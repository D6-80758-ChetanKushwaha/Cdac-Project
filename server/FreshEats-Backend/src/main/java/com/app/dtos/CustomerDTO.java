package com.app.dtos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString()
public class CustomerDTO {
	
	@JsonProperty(value = "customer_id",access = Access.READ_ONLY)
	private Long id;

	@NotBlank(message = "Customer name must be entered")
	private String firstName;
	
	@NotBlank(message = "Customer name must be entered")
	private String lastName;

	@NotBlank(message = "Customer name must be entered")
    private String username;

	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotBlank(message = "Email cannot be empty")
	private String email;
	
	@NotBlank
	//@Pattern(regexp="((?=.\\d)(?=.[a-z])(?=.[#@$]).{5,20})")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Size(min = 10, max = 10)
	private String contactInfo;
	
	@NotBlank(message = "Address must be entered")
	private String address;
	
	private UserRole role;
	
	private LocalDateTime createdAt;
}
