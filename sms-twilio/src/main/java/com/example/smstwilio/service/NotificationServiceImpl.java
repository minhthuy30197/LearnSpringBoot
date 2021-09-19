package com.example.smstwilio.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationServiceImpl implements NotificationService {
  @Value("${twilio.account_sid}")
  private String ACCOUNT_SID;

  @Value("${twilio.auth_token}")
  private String AUTH_TOKEN;

  @Value("${twilio.number}")
  private String TWILIO_NUMBER;

  @Override
  public boolean sendSMS(String phone, String message) {
    try {
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      Message msg = Message.creator(
          new PhoneNumber(phone),
          new PhoneNumber(TWILIO_NUMBER), message)
        .create();
    } catch (Exception ex) {
      log.info("Send sms to phone {} error {}", phone, ex);
      return false;
    }

    return true;
  }
}
