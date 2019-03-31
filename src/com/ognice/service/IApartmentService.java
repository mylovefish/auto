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
import com.ognice.domain.Apartment;

/**
*
* 部门管理 service接口类
*
**/
public interface IApartmentService {
//根据id获取
public Apartment getApartmentById(Integer id);
//保存入库
public String save(Apartment record);
//获取全部数据
public List<Apartment> all();
//分页获取
public PageResult getPages(PageSearchParam param);
//更新
public int update(Apartment record);
//删除
public int delete(Integer id);

}
