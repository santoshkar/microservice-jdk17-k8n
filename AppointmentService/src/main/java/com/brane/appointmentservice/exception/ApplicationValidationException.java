package com.brane.appointmentservice.exception;

public class ApplicationValidationException
	extends Exception {

	private static final long serialVersionUID = 8213399759427438939L;

	public ApplicationValidationException() {
		super();
	}

	public ApplicationValidationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApplicationValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationValidationException(String message) {
		super(message);
	}

	public ApplicationValidationException(Throwable cause) {
		super(cause);
	}
}
