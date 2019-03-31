package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Msg;
/**
*
* 消息管理 dao类
*
**/
public interface MsgMapper {
    int delete(Integer id);

    int insert(Msg record);

    Msg selectMsgById(Integer id);

    int update(Msg record);

    List<Msg> page(PageSearchParam param);
}