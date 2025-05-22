package br.com.portfolioweb.crud.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.portfolioweb.crud.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	//Qualquer do tipo da anotacao, e nao qualquer excessao aleatoria
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		 
		String erro = "I couldn't find the requested information";
		HttpStatus status = HttpStatus.NOT_FOUND;
		// instanciar o objeto StandardError
		StandardError errorPattern = new StandardError(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(errorPattern)	 ;	
	}
}
