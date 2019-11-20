package com.cdut.ym.demo.dto;

import com.cdut.ym.demo.exception.CustomizeErrorCode;
import lombok.Data;

import javax.xml.transform.Result;

/**
 * @Author: ym
 * @Date: 2019/11/19 21:01
 * @Version 1.0
 */
@Data
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode noLogin) {
        return errorOf(noLogin.getCode(), noLogin.getMessage());
    }
}
