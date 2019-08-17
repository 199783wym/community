package com.cdut.ym.demo.model;

import lombok.Data;

/**
 * @Author: ym
 * @Date: 2019/8/3 10:14
 * @Version 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
