package com.hastaakshar.builder.common;

public class InvalidDataException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidDataException(String message) {
		super(message);
	}

	public InvalidDataException(String message, Throwable e) {
		super(message, e);
	}

}
