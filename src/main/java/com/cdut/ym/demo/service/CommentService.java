package com.cdut.ym.demo.service;

import com.cdut.ym.demo.enums.CommentTypeEnum;
import com.cdut.ym.demo.exception.CustomizeErrorCode;
import com.cdut.ym.demo.exception.CustomizeException;
import com.cdut.ym.demo.mapper.CommentMapper;
import com.cdut.ym.demo.mapper.QuestionMapper;
import com.cdut.ym.demo.mapper.QuestioneExtMapper;
import com.cdut.ym.demo.model.Comment;
import com.cdut.ym.demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * @Author: ym
 * @Date: 2019/11/19 21:18
 * @Version 1.0
 */

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestioneExtMapper questioneExtMapper;

    @Transactional
     public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.COMMENT_PARAM_NOT_FOUNT);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }else{
                commentMapper.insert(comment);
            }
        }else{
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUNT);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questioneExtMapper.incCommentCount(question);
        }
    }
}
