package com.brane.doctors.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brane.doctors.entity.Doctor;
import com.brane.doctors.repository.DoctorRepository;
import com.brane.doctors.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	private DoctorRepository doctorRepository;
	
	private DoctorService doctorService;

	@Autowired
	public DoctorController(DoctorRepository doctorRepository, DoctorService doctorService) {
		this.doctorRepository = doctorRepository;
		this.doctorService = doctorService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Doctor>> findByCriteria(@RequestParam(required = false) String name,
			@RequestParam(required = false) String specialization, @RequestParam(required = false) String location) {

		List<Doctor> foundDoctors = doctorService.searchDoctors(name, specialization, location);

        if (foundDoctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(foundDoctors);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Doctor>> findAll() {
		List<Doctor> list = doctorRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> findById(@PathVariable Long id) {
		Optional<Doctor> optional = doctorRepository.findById(id);

		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		else
			return ResponseEntity.notFound().build();
	}
}
