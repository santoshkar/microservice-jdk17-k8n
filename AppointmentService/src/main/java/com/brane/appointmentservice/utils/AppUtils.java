package com.brane.appointmentservice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppUtils {
	public static LocalDateTime convertToLocalDateTime(String dateTimeString, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.parse(dateTimeString, formatter);
	}
}
