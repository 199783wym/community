package com.cdut.ym.demo.controller;

import com.cdut.ym.demo.dto.PaginationDTO;
import com.cdut.ym.demo.dto.QuestionDTO;
import com.cdut.ym.demo.mapper.QuestionMapper;
import com.cdut.ym.demo.mapper.UserMapper;
import com.cdut.ym.demo.model.Question;
import com.cdut.ym.demo.model.User;
import com.cdut.ym.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/4 16:31
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name="page",defaultValue = "1") Integer page,
                        @RequestParam(name="size",defaultValue = "5") Integer size
                        ){
        Cookie[] cookies=request.getCookies();
        if (cookies!=null && cookies.length!=0)
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

        PaginationDTO pagination =questionService.list(page,size);
//        for (QuestionDTO questionDTO : questionList) {
//            questionDTO.setDescription("ymmmmm");
//        }
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
