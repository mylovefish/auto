package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Apartment;
/**
*
* 部门管理 dao类
*
**/
public interface ApartmentMapper {
    int delete(Integer id);

    int insert(Apartment record);

    Apartment selectApartmentById(Integer id);

    int update(Apartment record);

    List<Apartment> page(PageSearchParam param);
}