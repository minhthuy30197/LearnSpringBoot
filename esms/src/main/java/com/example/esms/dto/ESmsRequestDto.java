package com.example.esms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ESmsRequestDto {
  @JsonProperty("ApiKey")
  private String apiKey;

  @JsonProperty("Content")
  private String content;

  @JsonProperty("Phone")
  private String phone;

  @JsonProperty("SecretKey")
  private String secretKey;

  @JsonProperty("IsUnicode")
  private String isUnicode;

  @JsonProperty("Brandname")
  private String brandname;

  @JsonProperty("SmsType")
  private String smsType;
}
