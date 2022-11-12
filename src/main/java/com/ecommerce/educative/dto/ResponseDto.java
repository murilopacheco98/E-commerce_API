package com.ecommerce.educative.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {
    public ResponseDto(String string, String string2) {
  }
    private String status;
    private String message;

}
