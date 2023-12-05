package com.brane.doctors.service;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.brane.doctors.entity.Doctor;

@Component
public class DoctorSpecifications {
    public static Specification<Doctor> filterDoctors(String name, String specialization, String location) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    name != null ? criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%") : criteriaBuilder.conjunction(),
                    specialization != null ? criteriaBuilder.like(criteriaBuilder.lower(root.get("specialization")), "%" + specialization.toLowerCase() + "%") : criteriaBuilder.conjunction(),
                    location != null ? criteriaBuilder.like(criteriaBuilder.lower(root.get("location")), "%" + location.toLowerCase() + "%") : criteriaBuilder.conjunction()
            );
        };
    }
}
