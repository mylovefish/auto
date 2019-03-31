package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Notice;
/**
*
* 公告管理 dao类
*
**/
public interface NoticeMapper {
    int delete(Integer id);

    int insert(Notice record);

    Notice selectNoticeById(Integer id);

    int update(Notice record);

    List<Notice> page(PageSearchParam param);
}