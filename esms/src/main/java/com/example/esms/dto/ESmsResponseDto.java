package com.example.esms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ESmsResponseDto {
  @JsonProperty("CodeResult")
  private String codeResult;

  @JsonProperty("CountRegenerate")
  private String countRegenerate;

  @JsonProperty("SMSID")
  private String smsId;
}
