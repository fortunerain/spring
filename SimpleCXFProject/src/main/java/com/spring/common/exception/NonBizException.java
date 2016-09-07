package com.spring.common.exception;


public class NonBizException extends BaseRunTimeException{

	private static final long serialVersionUID = -3931949833587614863L;

	public NonBizException(String message) {
		super(message);
	}
	
	public NonBizException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NonBizException(String code, String message) {
		super(code, message);
	}
	
}
