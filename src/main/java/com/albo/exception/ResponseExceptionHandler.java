package com.albo.exception;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger LOGGER = LogManager.getLogger(ResponseExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception ex, WebRequest request){
		LOGGER.error("Exception: " + ex.getMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> manejarModeloExcepciones(ModeloNotFoundException ex, WebRequest request){
		LOGGER.error("ModeloNotFoundException: " + ex.getMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error("MethodArgumentNotValidException: " + ex.getMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validación fallida", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataAccessException .class)
	public final ResponseEntity<ExceptionResponse> handleDataAccessException(DataAccessException ex, WebRequest request) {
		LOGGER.error("DataAccessException: " + ex.getCause().getCause().getMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getCause().getCause().getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { ModelAlreadyExistsException.class })
    public ResponseEntity<ExceptionResponse> handleAlreadyExist(ModelAlreadyExistsException ex, WebRequest request) {
		String errorMensaje = "ERROR: duplicate key value. " + ex.getMessage();
		LOGGER.error("ModelAlreadyExistsException: " + errorMensaje);
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), errorMensaje, request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.CONFLICT);
    }
		
}

