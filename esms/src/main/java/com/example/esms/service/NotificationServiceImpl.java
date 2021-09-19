package com.example.esms.service;

import com.example.esms.dto.ESmsRequestDto;
import com.example.esms.dto.ESmsResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class NotificationServiceImpl implements NotificationService {
  @Value("${esms.key.api}")
  private String apiKey;

  @Value("${esms.key.secret}")
  private String secretKey;

  @Value("${esms.url}")
  private String eSmsUrl;

  private static final String ESMS_SMS_TYPE = "8";

  private static final String ESMS_SUCCESS = "100";

  @Override
  public boolean sendSMS(String phone, String message) {
    try {
      ESmsRequestDto eSmsRequest = ESmsRequestDto.builder()
        .apiKey(apiKey)
        .secretKey(secretKey)
        .phone(phone)
        .content(message)
        .smsType(ESMS_SMS_TYPE)
        .build();
      RestTemplate restTemplate = new RestTemplate();
      HttpEntity<ESmsRequestDto> request = new HttpEntity<>(eSmsRequest);
      ResponseEntity<ESmsResponseDto> response = restTemplate.exchange(eSmsUrl, HttpMethod.POST, request, ESmsResponseDto.class);
      ESmsResponseDto eSmsResponse = response.getBody();
      log.info("Send sms to phone {} response {}", phone, eSmsResponse.getCodeResult());
      if (ESMS_SUCCESS.equals(eSmsResponse.getCodeResult())) {
        return true;
      }
    } catch (Exception ex) {
      log.info("Send sms to phone {} error {}", phone, ex);
    }
    return false;
  }
}
