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

        String[] strs = new String[10];
        int i =strs.length;
        int j= strs[i].length();
        char c = 'c';
        if (c != 'c') {

        }
        return co;
    }

    @RequestMapping("shop")
    public String shop(){
        return "shop";
    }
    @RequestMapping("shop1")
    public String shop1(){
        return "example01";
    }
    @RequestMapping("shop2")
    public String shop2(){
        return "example02";
    }
    @RequestMapping("shop3")
    public String shop3(){
        return "add";
    }
}
