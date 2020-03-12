package com.cdut.ym.demo.mapper;

import com.cdut.ym.demo.model.Comment;
import com.cdut.ym.demo.model.CommentExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
