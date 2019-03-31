package com.ognice.domain;

import java.util.Date;
/**
*
* 公告管理 实体类
*
**/
public class Notice {
    private Integer id;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String title;

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String desc;

	public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}