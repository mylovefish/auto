package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Comment;
/**
*
* 留言板管理 dao类
*
**/
public interface CommentMapper {
    int delete(Integer id);

    int insert(Comment record);

    Comment selectCommentById(Integer id);

    int update(Comment record);

    List<Comment> page(PageSearchParam param);
}