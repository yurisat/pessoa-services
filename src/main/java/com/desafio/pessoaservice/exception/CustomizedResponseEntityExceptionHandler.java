package com.desafio.pessoaservice.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.desafio.pessoaservice.dto.MensagemDTO;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<MensagemDTO> handleAllExceptions(Exception ex, WebRequest request) {
		
		MensagemDTO apiError = new MensagemDTO("Internal server error");
		return new ResponseEntity<MensagemDTO>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<MensagemDTO> handleJdbcExceptions(Exception ex, WebRequest request) {
		
		MensagemDTO apiError = new MensagemDTO("Erro ao gravar dados de pessoa.");
		return new ResponseEntity<MensagemDTO>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(NotFoundException.class) 
	public final ResponseEntity<MensagemDTO> handleNotFoudException(NotFoundException ex, WebRequest request) {
		
		MensagemDTO apiError = new MensagemDTO(ex.getMessage());
		return new ResponseEntity<MensagemDTO>(apiError, HttpStatus.NOT_FOUND);
		
	}

}
