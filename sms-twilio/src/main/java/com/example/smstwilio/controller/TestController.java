package com.example.smstwilio.controller;

import com.example.smstwilio.dto.SendSMSRequest;
import com.example.smstwilio.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TestController {
  @Autowired
  private NotificationService notificationService;

  @PostMapping("/sms")
  public ResponseEntity<?> sendSMS(@RequestBody SendSMSRequest sendSMSRequest) {
    return ResponseEntity.ok(notificationService.sendSMS(sendSMSRequest.getPhone(), sendSMSRequest.getMessage()));
  }
}
