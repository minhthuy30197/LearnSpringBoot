package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusResponse {
  private int status;

  private String code;

  private String message;

  private Object data;
}
