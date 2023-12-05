package com.brane.appointmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brane.appointmentservice.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
