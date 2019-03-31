package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Meeting;
/**
*
* 会议管理 dao类
*
**/
public interface MeetingMapper {
    int delete(Integer id);

    int insert(Meeting record);

    Meeting selectMeetingById(Integer id);

    int update(Meeting record);

    List<Meeting> page(PageSearchParam param);
}