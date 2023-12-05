package com.brane.appointmentservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brane.appointmentservice.entity.Appointment;
import com.brane.appointmentservice.repository.AppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {
	
	private AppointmentRepository repository;
	
	public AppointmentService(AppointmentRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Appointment> findAll() {
		return repository.findAll();
	}
	
}
