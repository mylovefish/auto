package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Juese;
/**
*
* 角色管理 dao类
*
**/
public interface JueseMapper {
    int delete(Integer id);

    int insert(Juese record);

    Juese selectJueseById(Integer id);

    int update(Juese record);

    List<Juese> page(PageSearchParam param);
}