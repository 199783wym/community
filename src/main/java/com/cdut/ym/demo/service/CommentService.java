package com.cdut.ym.demo.service;

import com.cdut.ym.demo.model.Comment;
import org.springframework.stereotype.Service;

/**
 * @Author: ym
 * @Date: 2019/11/19 21:18
 * @Version 1.0
 */
@Service
public class CommentService {
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            return
        }
    }
}
