package com.concepts.demo.userexception;

public class CustomNotFoundException extends RuntimeException {
	private String message;
	private int value;

	public CustomNotFoundException(String message) {
		super(message);

	}

	public String getMessage() {
		return message;
	}

	public int getValue() {
		return value;
	}
}
