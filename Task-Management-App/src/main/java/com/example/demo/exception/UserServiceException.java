package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class UserServiceException extends RuntimeException {

	private String errorMessage;
	private HttpStatus httpStatus;

	public UserServiceException(String errorMessage, HttpStatus httpStatus) {
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}