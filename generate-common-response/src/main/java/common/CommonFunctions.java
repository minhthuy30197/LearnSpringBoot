package common;

import dto.StatusResponse;

public class CommonFunctions {
  public static StatusResponse generateResponse(ErrorEnum errorEnum, Object data) {
    return StatusResponse.builder()
      .status(errorEnum.getStatus())
      .code(errorEnum.getCode())
      .message(errorEnum.getMessage())
      .data(data)
      .build();
  }
}
