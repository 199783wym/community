package com.cdut.ym.demo.dto;

import com.cdut.ym.demo.model.User;
import lombok.Data;

/**
 * @Author: ym
 * @Date: 2019/8/15 23:15
 * @Version 1.0
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
