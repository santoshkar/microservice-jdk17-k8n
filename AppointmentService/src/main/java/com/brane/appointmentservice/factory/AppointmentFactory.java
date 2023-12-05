package com.brane.appointmentservice.factory;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.brane.appointmentservice.dto.AppointmentBookingDto;
import com.brane.appointmentservice.entity.Appointment;
import com.brane.appointmentservice.exception.ApplicationValidationException;
import com.brane.appointmentservice.exception.DoctorNotAvailableException;
import com.brane.appointmentservice.exception.SlotNotAvailableException;
import com.brane.appointmentservice.utils.AppUtils;

@Component
public class AppointmentFactory {
	public Appointment createAppointment(AppointmentBookingDto dto) 
			throws ApplicationValidationException {

		String dateTimeFormat = "dd-MM-yyyy HH:mm";

		String appointmentDateString = dto.getAppointmentDate()+" "+dto.getAppointmentTime();
		LocalDateTime appointmentDate = AppUtils.convertToLocalDateTime(appointmentDateString, dateTimeFormat);

		if (!isAppointmentValid(appointmentDate)) {
			throw new ApplicationValidationException("Date is not valid as it's past date");
		}
		

		if (!isAppointmentSlotAvailable(appointmentDate)) {
			throw new SlotNotAvailableException();
		}

		if (!isDoctorAvailableThatDay(appointmentDate)) {
			throw new DoctorNotAvailableException();
		}

		return Appointment.builder().appointmentDate(appointmentDate).doctorId(dto.getDoctorId())
				.patientId(dto.getPatientId()).status("Booked").build();
	}

	private boolean isAppointmentValid(LocalDateTime appointmentDateTime) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		return !appointmentDateTime.isBefore(currentDateTime);
	}

	private boolean isAppointmentSlotAvailable(LocalDateTime appointmentDateTime) {
		// TODO: Write logic
		return true;
	}

	private boolean isDoctorAvailableThatDay(LocalDateTime appointmentDateTime) {
		// TODO: Write logic
		return true;
	}
}