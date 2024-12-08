package com.example.product_category.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	//specific exception
    @ExceptionHandler
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e){
		ErrorResponse errorResponse=new ErrorResponse();
	    errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	    errorResponse.setMessage(e.getMessage());
	    errorResponse.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
    
    //global exception
    public ResponseEntity<ErrorResponse> handleException(Exception e){
    	ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(),LocalDateTime.now());
    	return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    
	
}
