package com.app.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.app.entities.Role;
import com.app.entities.SellerEntity;
import com.app.entities.SellerStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;

@Getter
@Setter
@ToString
public class SellerDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	
	@NotBlank(message = "First name should not be null")
	private String firstName;

	@NotBlank(message = "Last name should not be null")
	private String lastName;
	
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotBlank(message = "Email cannot be empty")
	private String email;
	
	@NotBlank
	//@Pattern(regexp="((?=.\\d)(?=.[a-z])(?=.[#@$]).{5,20})")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@NotBlank
//	1.String is not null
//	2.Trimmed length is greater than zero
	@Size(min = 10, max = 10)
	private String contactInfo;
	
	@NotBlank
	private String address;
    
	//@NotBlank
    private SellerStatus status;
    
    private Role role;


}
