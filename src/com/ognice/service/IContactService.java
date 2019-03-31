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
import com.ognice.domain.Contact;

/**
*
* 通讯录 service接口类
*
**/
public interface IContactService {
//根据id获取
public Contact getContactById(Integer id);
//保存入库
public String save(Contact record);
//获取全部数据
public List<Contact> all();
//分页获取
public PageResult getPages(PageSearchParam param);
//更新
public int update(Contact record);
//删除
public int delete(Integer id);

}
