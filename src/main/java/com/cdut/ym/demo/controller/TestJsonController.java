package com.cdut.ym.demo.controller;

import com.cdut.ym.demo.dto.CommentDTO;
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
    public CommentDTO test(CommentDTO co){
//        Comment co = new Comment();
        co.setContent("aaa");
//        co.setParentId(Long.valueOf(id));
        System.out.println(co.getParentId()+"parentId");

        return co;
    }
}
