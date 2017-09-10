package org.practice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(){
		System.out.println("Received null pointer exception ..");
		return "nullpointer_exception";
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handleGlobalException(){
		System.out.println("Received global exception ..");
		return "global_exception";
	}
	
}
