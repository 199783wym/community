package com.cdut.ym.demo.dto;

import com.cdut.ym.demo.model.User;
import lombok.Data;

/**
 * @Author: ym
 * @Date: 2020/3/7 18:25
 * @Version 1.0
 */
@Data
public class CommentDTO {

    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
    private Integer commentCount;


}
