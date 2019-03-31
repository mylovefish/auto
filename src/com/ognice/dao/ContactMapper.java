package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Contact;
/**
*
* 通讯录 dao类
*
**/
public interface ContactMapper {
    int delete(Integer id);

    int insert(Contact record);

    Contact selectContactById(Integer id);

    int update(Contact record);

    List<Contact> page(PageSearchParam param);
}