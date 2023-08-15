package com.ClaimsManagementSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<String> handleMemberNotFoundException(MemberNotFoundException memberNotFoundException){
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(memberNotFoundException.getMessage());
	}
	
	@ExceptionHandler(ClaimsNotFoundException.class)
	public ResponseEntity<String> handleClaimsNotFoundException(ClaimsNotFoundException claimsNotFoundException){
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(claimsNotFoundException.getMessage());
	}
}
