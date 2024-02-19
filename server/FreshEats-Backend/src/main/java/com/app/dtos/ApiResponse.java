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
	Boolean status;
	
	public ApiResponse(String msg, Boolean status) {
		this.msg = msg;
		this.status = status;
		time = LocalDateTime.now();
	}	

}