package com.cdut.ym.demo.dto;

import lombok.Data;

/**
 * @Author: ym
 * @Date: 2019/7/13 16:55
 * @Version 1.0
 */
@Data
public class GithubUser {
    private String name;
    private  Long id;
    private  String bio;
    private String avatar_url;

}
