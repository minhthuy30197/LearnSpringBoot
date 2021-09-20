package common;

public enum ErrorEnum {
  SUCCESS(200, "0", "Success"),
  INTERNAL_SERVER_ERROR(500, "500", "Internal Server Error"),
  USER_NOT_FOUND(400, "100", "User not found in system"),
  PHONE_EXIST(400, "101", "Phone existed in system");

  private int status;
  private String code;
  private String message;

  ErrorEnum(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public int getStatus() {
    return status;
  }

  public static ErrorEnum getErrorEnum(String code) {
    for (ErrorEnum ee : ErrorEnum.values()) {
      if (ee.getCode().equals(code)) {
        return ee;
      }
    }

    return INTERNAL_SERVER_ERROR;
  }
}
