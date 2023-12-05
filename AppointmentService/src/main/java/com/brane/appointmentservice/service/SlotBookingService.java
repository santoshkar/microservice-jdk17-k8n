package com.brane.appointmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brane.appointmentservice.dto.AppointmentBookingDto;
import com.brane.appointmentservice.entity.Appointment;
import com.brane.appointmentservice.exception.ApplicationValidationException;
import com.brane.appointmentservice.factory.AppointmentFactory;
import com.brane.appointmentservice.repository.AppointmentRepository;

@Service
public class SlotBookingService implements ISlotBookingService {

	private AppointmentFactory appointmentFactory;

	private AppointmentRepository appointmentRepository;
	
	@Autowired
    public SlotBookingService(
    		AppointmentFactory appointmentFactory, 
    		AppointmentRepository appointmentRepository) {
        this.appointmentFactory = appointmentFactory;
        this.appointmentRepository = appointmentRepository;
    }

	@Override
	public Appointment bookSlot(AppointmentBookingDto dto) throws ApplicationValidationException {
		Appointment e = appointmentFactory.createAppointment(dto);
		return appointmentRepository.save(e);
	}
}
