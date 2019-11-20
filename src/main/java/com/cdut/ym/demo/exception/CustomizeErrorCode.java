package com.cdut.ym.demo.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUNT(2001,"你找的问题不存在了，真的"),
    COMMENT_PARAM_NOT_FOUNT(2001,"未选中任何问题或评论"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试");

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
