package com.brane.notification.service;
public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
