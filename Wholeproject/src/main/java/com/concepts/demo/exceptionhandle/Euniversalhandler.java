package com.concepts.demo.exceptionhandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.concepts.demo.userexception.Handlingpredefined;
import com.concepts.demo.userexception.CustomNotFoundException;

@RestControllerAdvice
public class Euniversalhandler {
	@ExceptionHandler(CustomNotFoundException.class)
	public ResponseEntity<String> handlingcoustmexception(CustomNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Handlingpredefined> handlingmethodargumnet(MethodArgumentNotValidException e) {
		String message = e.getBindingResult().getFieldError().getDefaultMessage();
		Handlingpredefined result = new Handlingpredefined(message, HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<Handlingpredefined>(result, HttpStatus.BAD_REQUEST);
	}

}