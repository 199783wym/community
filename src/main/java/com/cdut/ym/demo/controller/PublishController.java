package com.cdut.ym.demo.controller;

import com.cdut.ym.demo.mapper.QuestionMapper;
import com.cdut.ym.demo.mapper.UserMapper;
import com.cdut.ym.demo.model.Question;
import com.cdut.ym.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ym
 * @Date: 2019/8/6 17:18
 * @Version 1.0
 */
@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model){

        User user=null;
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie :cookies){
            if (cookie.getName().equals("token")) {
                String token =cookie.getValue();
                user =userMapper.findByToken(token);
                if (user!= null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        if(user==null){
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());



        questionMapper.create(question);
        return "redirect:/";
    }
}
