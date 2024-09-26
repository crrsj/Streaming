package com.projeto.netflix.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.netflix.dto.FoundErrors;

@ControllerAdvice
public class ControlleraAdvice {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<FoundErrors>streamingNotFound(){
		var notFound = new FoundErrors(HttpStatus.NOT_FOUND, "Streaming not found !");
		return new ResponseEntity<>(notFound,HttpStatus.NOT_FOUND);
	}

}
