package com.example.stock.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler(UpdateNotAllowed.class)
	ResponseEntity<StandardError> updateNotAllowed(UpdateNotAllowed exception) {

		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
		err.setError("Update not Allowed");
		err.setMessage(exception.getMessage());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(err);

	}

}
