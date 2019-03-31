package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Plan;
/**
*
* 日程管理 dao类
*
**/
public interface PlanMapper {
    int delete(Integer id);

    int insert(Plan record);

    Plan selectPlanById(Integer id);

    int update(Plan record);

    List<Plan> page(PageSearchParam param);
}