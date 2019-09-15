package com.cdut.ym.demo.service;

import com.cdut.ym.demo.dto.PaginationDTO;
import com.cdut.ym.demo.dto.QuestionDTO;
import com.cdut.ym.demo.mapper.QuestionMapper;
import com.cdut.ym.demo.mapper.UserMapper;
import com.cdut.ym.demo.model.Question;
import com.cdut.ym.demo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ym
 * @Date: 2019/8/15 23:18
 * @Version 1.0
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {


        //size*{page-1}
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount = questionMapper.count();

        if(totalCount % size ==0){
            totalPage= totalCount/size;
        }else{
            totalPage =totalCount/size+1;
        }

        if(page<1){
            page =1;
        }
        if(page>totalPage){
            page=totalPage;
        }
        paginationDTO.setPagination(totalPage,page);

        Integer offset = size* (page-1);

        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList =new ArrayList<>();


        for (Question question :
                questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount = questionMapper.countByUserId(userId);

        if(totalCount % size ==0){
            totalPage= totalCount/size;
        }else{
            totalPage =totalCount/size+1;
        }

        if(page<1){
            page =1;
        }
        if(page>totalPage){
            page=totalPage;
        }
        paginationDTO.setPagination(totalPage,page);

        Integer offset = size* (page-1);

        List<Question> questions = questionMapper.listByUserId(userId,offset,size);
        List<QuestionDTO> questionDTOList =new ArrayList<>();


        for (Question question :
                questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);

        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;

    }
}
