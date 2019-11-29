package com.cdut.ym.demo.controller;

import com.cdut.ym.demo.model.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestJsonController {
    @RequestMapping("/test")
    @ResponseBody
    public Comment test (@RequestBody Comment co){
        co.setId(111111L);
        co.setCommentator(1111111);
        co.setGmtCreate(System.currentTimeMillis());
        return co;
    }
}
