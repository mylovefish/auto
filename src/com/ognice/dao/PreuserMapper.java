package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Preuser;
/**
*
* 用户管理 dao类
*
**/
public interface PreuserMapper {
    int delete(Integer id);

    int insert(Preuser record);

    Preuser selectPreuserById(Integer id);

    int update(Preuser record);

    List<Preuser> page(PageSearchParam param);
}