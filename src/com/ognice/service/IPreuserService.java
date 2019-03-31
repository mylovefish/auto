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
import com.ognice.domain.Preuser;

/**
*
* 用户管理 service接口类
*
**/
public interface IPreuserService {
//根据id获取
public Preuser getPreuserById(Integer id);
//保存入库
public String save(Preuser record);
//获取全部数据
public List<Preuser> all();
//分页获取
public PageResult getPages(PageSearchParam param);
//更新
public int update(Preuser record);
//删除
public int delete(Integer id);

}
