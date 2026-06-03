package com.example.demo.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.TaskServiceException;
import com.example.demo.exception.UserServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGlobalException(Exception exception) {

		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserServiceException.class)
	public ResponseEntity<String> handleUserServiceException(UserServiceException exception) {

		return new ResponseEntity<>(exception.getMessage(), exception.getHttpStatus());
	}

	@ExceptionHandler(TaskServiceException.class)
	public ResponseEntity<String> handleTaskServiceException(TaskServiceException exception) {

		return new ResponseEntity<>(exception.getMessage(), exception.getHttpStatus());
	}
}