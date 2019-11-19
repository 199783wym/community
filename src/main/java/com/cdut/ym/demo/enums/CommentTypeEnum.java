package com.cdut.ym.demo.enums;

/**
 * @Author: ym
 * @Date: 2019/11/19 21:13
 * @Version 1.0
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2)
    ;

    private Integer type;

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
