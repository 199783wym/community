package com.cdut.ym.demo.controller;

import com.cdut.ym.demo.mapper.UserMapper;
import com.cdut.ym.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ym
 * @Date: 2019/8/4 16:31
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie :cookies){
            if (cookie.getName().equals("token")) {
                String token =cookie.getValue();
                User user =userMapper.findByToken(token);
                if (user!= null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";

    }
}
