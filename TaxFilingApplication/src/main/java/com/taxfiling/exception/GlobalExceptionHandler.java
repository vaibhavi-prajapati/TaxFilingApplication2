package com.taxfiling.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(basePackages = "com.taxfiling.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	GlobalExceptionHandler() {
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<CustomExceptionSchema> handleEnitiyNotFoundException(EntityNotFoundException ex) {
		CustomExceptionSchema customError = new CustomExceptionSchema(ex.getMessage(), ex.getDetails(), ex.getHint(),
				ex.getNextActions(), ex.getSupport());
		return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateEntryFoundException.class)
	public final ResponseEntity<CustomExceptionSchema> handleDupliateEntryFoundException(
			DuplicateEntryFoundException ex) {
		CustomExceptionSchema customError = new CustomExceptionSchema(
				HttpStatus.CONFLICT.getReasonPhrase() + ": " + ex.getMessage(), ex.getDetails(), ex.getHint(),
				ex.getNextActions(), ex.getSupport());
		return new ResponseEntity<>(customError, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<CustomExceptionSchema> handleConstraintViolationException(ConstraintViolationException ex) {
		CustomExceptionSchema customError = new CustomExceptionSchema(
				HttpStatus.EXPECTATION_FAILED.getReasonPhrase() + ": " + ex.getClass().getSimpleName(),
				ex.getConstraintViolations().iterator().next().getMessage(),
				ex.getConstraintViolations().iterator().next().getPropertyPath().toString()
						+ " doesn't meet expectations",
				"Try again with correct details", "Reach out to ithelpdesk@taxportal.com");
		return new ResponseEntity<>(customError, HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomExceptionSchema> handleException(Exception ex) {
		CustomExceptionSchema customError = new CustomExceptionSchema(ex.getClass().getSimpleName(), ex.getMessage(),
				ex.getCause().toString(), "Try again with correct details", "Reach out to ithelpdesk@taxportal.com");
		return new ResponseEntity<>(customError, HttpStatus.BAD_REQUEST);
	}
}
