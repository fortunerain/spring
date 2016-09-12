package com.minho.study.common.exception;

public class BaseException extends Exception{

	private static final long serialVersionUID = 2920308173045987901L;
	private String code;

	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(String code, String message) {
		this(message);
		this.code = code;
	}
	
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public String getCode() {
		return code;
	}
}
