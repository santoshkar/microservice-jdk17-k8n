package com.brane.appointmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brane.appointmentservice.dto.AppointmentBookingDto;
import com.brane.appointmentservice.entity.Appointment;
import com.brane.appointmentservice.exception.ApplicationValidationException;
import com.brane.appointmentservice.notification.EmailRequest;
import com.brane.appointmentservice.notification.NotificationClient;
import com.brane.appointmentservice.service.IAppointmentService;
import com.brane.appointmentservice.service.ISlotBookingService;

@RestController
public class AppointmentController {

	private ISlotBookingService slotBookingService;

	private IAppointmentService appointmentService;
	
	private NotificationClient notification;

	@Autowired
	public AppointmentController(ISlotBookingService slotBookingService,
			IAppointmentService appointmentService,
			NotificationClient notification) {
		this.slotBookingService = slotBookingService;
		this.appointmentService = appointmentService;
		this.notification = notification;
	}

	@PostMapping("/appointment/book")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody AppointmentBookingDto request)
			throws ApplicationValidationException {
		Appointment e = slotBookingService.bookSlot(request);
		
		EmailRequest emailReq = EmailRequest.builder().to("santoshkumarkar.com").subject("Appoint Confirmed")
		.text("Your appointment confirmed for date XXXXX with doctoer XXXXX").build();
		notification.sendEmail(emailReq);
		return ResponseEntity.ok(e);
	}

	@PostMapping("/appointment/all")
	public ResponseEntity<List<Appointment>> bookAppointment() throws ApplicationValidationException {
		List<Appointment> e = appointmentService.findAll();
		return ResponseEntity.ok(e);
	}
}
