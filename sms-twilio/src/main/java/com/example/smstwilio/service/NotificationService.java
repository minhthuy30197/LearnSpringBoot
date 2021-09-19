package com.example.smstwilio.service;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
  boolean sendSMS(String phone, String message);
}
