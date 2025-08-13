package com.mymart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	 @ExceptionHandler(DuplicateEntryException.class)
     public ResponseEntity<String> duplicateEntryException(DuplicateEntryException exception)
     {
    	 return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
     }
	 
	 @ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException exception)
	 {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	 }
}
