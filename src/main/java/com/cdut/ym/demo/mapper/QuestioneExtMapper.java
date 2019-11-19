package com.cdut.ym.demo.mapper;

import com.cdut.ym.demo.model.Question;
import com.cdut.ym.demo.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestioneExtMapper {
    int incView(Question record);
}