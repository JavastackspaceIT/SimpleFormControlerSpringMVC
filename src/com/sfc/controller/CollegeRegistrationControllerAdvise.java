package com.sfc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sfc.error.CollegeRegError;
import com.sfc.exception.CollegetException;

@ControllerAdvice
public class CollegeRegistrationControllerAdvise {

	@ExceptionHandler(CollegetException.class)
	public ResponseEntity<CollegeRegError> collegeRegError(CollegetException collegetException) {
		CollegeRegError collegeRegError = new CollegeRegError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				collegetException.getMessage());
		return new ResponseEntity<CollegeRegError>(collegeRegError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
