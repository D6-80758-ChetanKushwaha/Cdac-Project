package com.app.dtos;

import java.time.LocalDateTime;

//import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class ApiResponse {
	LocalDateTime time;
	String msg;
	
	public ApiResponse(String msg) {
		this.msg = msg;
		time = LocalDateTime.now();
	}	

}