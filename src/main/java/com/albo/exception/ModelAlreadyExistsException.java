package com.albo.exception;

public class ModelAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
//	private String message;
	
    public ModelAlreadyExistsException(String message) {
        super(message);
//        this.message = message;
    }
    
//    public ModelAlreadyExistsException() {
//    }    
}
