package com.brane.appointmentservice.service;

import com.brane.appointmentservice.dto.AppointmentBookingDto;
import com.brane.appointmentservice.entity.Appointment;
import com.brane.appointmentservice.exception.ApplicationValidationException;

public interface ISlotBookingService {

	Appointment bookSlot(AppointmentBookingDto request) throws ApplicationValidationException;
	
}
