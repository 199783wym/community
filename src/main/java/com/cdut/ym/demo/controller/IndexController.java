package com.cdut.ym.demo.controller;

import com.cdut.ym.demo.dto.PaginationDTO;
import com.cdut.ym.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: ym
 * @Date: 2019/8/4 16:31
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name="size",defaultValue = "5") Integer size
                        ){


        PaginationDTO pagination =questionService.list(page,size);
//        for (QuestionDTO questionDTO : questionList) {
//            questionDTO.setDescription("ymmmmm");
//        }
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
