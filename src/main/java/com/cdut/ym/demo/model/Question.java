package com.cdut.ym.demo.model;

import lombok.Data;

/**
 * @Author: ym
 * @Date: 2019/8/11 10:57
 * @Version 1.0
 */
public @Data class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
