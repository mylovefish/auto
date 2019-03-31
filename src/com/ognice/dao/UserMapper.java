package com.ognice.dao;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Preuser;
import com.ognice.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);


    User selectByPrimaryKey(Integer id);

    User selectByUsername(String u);

    User login(String u, String p);
    Preuser prelogin(String u, String p);

    int updateByPrimaryKeySelective(User record);


    List<User> page(PageSearchParam param);


}