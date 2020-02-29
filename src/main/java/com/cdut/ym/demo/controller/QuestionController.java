package com.cdut.ym.demo.controller;

import com.cdut.ym.demo.dto.QuestionDTO;
import com.cdut.ym.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ym
 * @Date: 2019/9/15 10:46
 * @Version 1.0
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id") Long id,
    Model model){
        QuestionDTO questionDTO= questionService.getById(id);
        //点击时增加阅读数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
