package com.practice.jwtredisstudy.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTemplate {

    public Integer code;

    public String message;

    public Object data;
}
