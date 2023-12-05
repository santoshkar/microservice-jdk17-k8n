package com.brane.appointmentservice.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATIONSERVICE")
public interface NotificationClient {
	@PostMapping(value = "/email/send")
	ResponseEntity<String> sendEmail(@RequestBody EmailRequest request);
}