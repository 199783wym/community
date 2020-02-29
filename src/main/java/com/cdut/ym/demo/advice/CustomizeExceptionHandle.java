package com.cdut.ym.demo.advice;

import com.alibaba.fastjson.JSON;
import com.cdut.ym.demo.dto.ResultDTO;
import com.cdut.ym.demo.exception.CustomizeErrorCode;
import com.cdut.ym.demo.exception.CustomizeException;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomizeExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ModelAndView handle(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response){

        String contentType = request.getContentType();

        if ("application/json".equals(contentType)) {
            ResultDTO resultDTO ;
           //返回json
            if (e instanceof CustomizeException) {
                resultDTO = ResultDTO.errorOf((CustomizeException)e);

            }else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString((resultDTO)));
                writer.close();

            } catch (IOException ioe) {
            }
            return null;
        }else{
            //返回错误页面
            if (e instanceof CustomizeException) {
                model.addAttribute("message", e.getMessage());

            }else{
                model.addAttribute("message", "盲生你发现了华点！！");

            }
            return new ModelAndView("error");
        }
    }

//    private HttpStatus getStatus(HttpServletRequest request){
//        Integer statusCode = (Integer) request.getAttribute("java.servlet.error.status_code");
//        if(statusCode ==null){
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        return HttpStatus.valueOf(statusCode);
//    }
}
