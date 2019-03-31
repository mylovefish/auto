package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Meetuser;
/**
*
*  dao类
*
**/
public interface MeetuserMapper {
    int delete(Integer id);

    int insert(Meetuser record);

    Meetuser selectMeetuserById(Integer id);

    int update(Meetuser record);

    List<Meetuser> page(PageSearchParam param);
}