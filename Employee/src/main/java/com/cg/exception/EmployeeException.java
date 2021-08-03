package com.cg.exception;

public class EmployeeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	String message;
	
	public class EmployeeNotFoundException extends RuntimeException{
		public EmployeeNotFoundException(String message) {
			super(message);
		}
	}

	public EmployeeException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}

}
