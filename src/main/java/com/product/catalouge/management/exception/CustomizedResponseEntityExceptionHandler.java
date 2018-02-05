package com.product.catalouge.management.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(ProductNotFoundException.class)
	  public final ResponseEntity<Errors> handleUserNotFoundException(ProductNotFoundException ex, WebRequest request) {
	    Errors errorDetails = (Errors) new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  
}