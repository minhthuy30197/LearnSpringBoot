package com.example.esms.service;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
  boolean sendSMS(String phone, String message);
  boolean sendVoiceOTP(String phone, String otp);
}
