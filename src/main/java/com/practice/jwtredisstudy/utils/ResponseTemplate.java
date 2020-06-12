package com.practice.jwtredisstudy.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTemplate<T> {

    /**
     *响应码
     */
    public String code;

    /**
     * 响应消息
     */
    public String message;

    /**
     * 返回数据
     */
    public T data;

    public static ResponseTemplate ok(String code, String message, Object data) {
        return new ResponseTemplate(code, message, data);
    }
}
