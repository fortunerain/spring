package com.spring.common.exception;

public class BaseRunTimeException extends RuntimeException{

	private static final long serialVersionUID = 2920308173045987901L;
	private String code;

	public BaseRunTimeException(String message) {
		super(message);
	}
	
	public BaseRunTimeException(String code, String message) {
		this(message);
		this.code = code;
	}
	
	public BaseRunTimeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public String getCode() {
		return code;
	}
}
