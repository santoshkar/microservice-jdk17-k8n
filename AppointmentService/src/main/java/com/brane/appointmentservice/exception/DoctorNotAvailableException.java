package com.brane.appointmentservice.exception;

public class DoctorNotAvailableException extends ApplicationValidationException {

	private static final long serialVersionUID = -7459076189641459819L;

	private static final String MESSAGE = "Doctor is unavailable on for the slot. Please select another time or consider another doctor's availability.";
	
	public DoctorNotAvailableException() {
		super(MESSAGE);
	}
}
