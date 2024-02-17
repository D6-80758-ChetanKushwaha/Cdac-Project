package com.app.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SigninDTO {
	
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotBlank(message = "Email cannot be empty")
	private String email;
	
	@NotBlank
	//@Pattern(regexp="((?=.\\d)(?=.[a-z])(?=.[#@$]).{5,20})")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

}
