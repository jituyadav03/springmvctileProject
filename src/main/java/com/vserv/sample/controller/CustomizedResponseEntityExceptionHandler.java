package com.vserv.sample.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vserv.sample.exception.ErrorDetails;
import com.vserv.sample.exception.NoteNotFoundException;

@ControllerAdvice
//@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NoteNotFoundException.class)
  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(NoteNotFoundException ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  /* coomon for all the errors ......*/
  private ResponseEntity<String> error(HttpStatus status, Exception e) {
      return ResponseEntity.status(status).body(e.getMessage());
  }
  
	/*
	 * @ResponseStatus(HttpStatus.NOT_FOUND)
	 * 
	 * @ExceptionHandler({DogsNotFoundException.class}) public void
	 * handle(DogsNotFoundException e) {}
	 * 
	 * @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	 * 
	 * @ExceptionHandler({DogsServiceException.class, SQLException.class,
	 * NullPointerException.class}) public void handle() {}
	 * 
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler({DogsServiceValidationException.class}) public void
	 * handle(DogsServiceValidationException e) {}
	 */
  
}