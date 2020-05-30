package com.hastaakshar.builder.common;

public class SystemFailureException extends Exception {

	private static final long serialVersionUID = 1L;

	public SystemFailureException(String message) {
		super(message);
	}

	public SystemFailureException(String message, Throwable e) {
		super(message, e);
	}

}
