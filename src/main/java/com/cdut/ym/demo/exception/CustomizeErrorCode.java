package com.cdut.ym.demo.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUNT(2001,"你找的问题不存在了，真的");

    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message)
    {
        this.message=message;
        this.code=code;
    }

}
