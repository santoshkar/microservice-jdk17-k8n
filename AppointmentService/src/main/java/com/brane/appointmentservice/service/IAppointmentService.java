package com.brane.appointmentservice.service;

import java.util.List;

import com.brane.appointmentservice.entity.Appointment;

public interface IAppointmentService {
	List<Appointment> findAll();
}
