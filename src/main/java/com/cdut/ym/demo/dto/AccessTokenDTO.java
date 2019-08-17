package com.cdut.ym.demo.dto;

import lombok.Data;

/**
 * @Author: ym
 * @Date: 2019/7/12 16:40
 * @Version 1.0
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
