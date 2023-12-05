package com.brane.appointmentservice.dto;

import lombok.Data;

@Data
public class AppointmentBookingDto {
	private long doctorId;
	private long patientId;
	private String appointmentDate;
	private String appointmentTime;
}
