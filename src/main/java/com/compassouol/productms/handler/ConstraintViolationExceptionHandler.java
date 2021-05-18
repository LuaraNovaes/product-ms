package com.compassouol.productms.handler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@AllArgsConstructor
@Log4j2
public class ConstraintViolationExceptionHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorApiDTO handle(ConstraintViolationException ex) {
		log.error("Validation Errors: {}", ex.getMessage());
		return buildErroApiDTO(ex);
	}
    
	private ErrorApiDTO buildErroApiDTO(ConstraintViolationException ex) {
		List<ValidationDTO> listErrors = convertToFormValidationDTO(ex.getConstraintViolations());
		return ErrorApiDTO.builder()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.message("ERROR TO VALID METHOD")
				.validationsError(listErrors)
				.build();
	}
	
	private List<ValidationDTO> convertToFormValidationDTO(Set<ConstraintViolation<?>> constraintViolations) {
		return constraintViolations.stream().map(e -> toFormValidationDTO(e)).collect(Collectors.toList());
	}
	
	private ValidationDTO toFormValidationDTO(ConstraintViolation<?> fieldError) {
		return ValidationDTO.builder()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.message("FIELD = "+ fieldError.getPropertyPath().toString()
						+" - MESSAGE " + fieldError.getMessage())
				.build();
	}
}
