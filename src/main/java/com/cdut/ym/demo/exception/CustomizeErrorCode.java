package com.cdut.ym.demo.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUNT("你找的问题不存在了，真的");
    @Override
    public String getMessage(){
        return message;
    }
    private String message;

    CustomizeErrorCode(String message) {
        this.message=message;
    }

}
