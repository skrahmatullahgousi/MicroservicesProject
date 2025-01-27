package com.concepts.demo.userexception;

public class Handlingpredefined extends RuntimeException {
	String message;
	int value;

	public Handlingpredefined(String message, int value) {
		this.message = message;
		this.value = value;

	}

	public String getMessage() {
		return message;
	}

	public int getValue() {
		return value;
	}
}