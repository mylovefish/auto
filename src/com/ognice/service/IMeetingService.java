/**
*
*/
package com.ognice.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Meeting;

/**
*
* 会议管理 service接口类
*
**/
public interface IMeetingService {
//根据id获取
public Meeting getMeetingById(Integer id);
//保存入库
public String save(Meeting record);
//获取全部数据
public List<Meeting> all();
//分页获取
public PageResult getPages(PageSearchParam param);
//更新
public int update(Meeting record);
//删除
public int delete(Integer id);

}
