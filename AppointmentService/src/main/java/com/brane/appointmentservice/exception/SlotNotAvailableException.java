package com.brane.appointmentservice.exception;

public class SlotNotAvailableException extends ApplicationValidationException {

	private static final long serialVersionUID = -7459076189641459819L;

	private static final String MESSAGE = "The time slot is unavailable. Please select another time or consider another doctor's availability.";
	
	public SlotNotAvailableException() {
		super(MESSAGE);
	}
}
