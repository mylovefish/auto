package com.ognice.domain;

import java.util.Date;
/**
*
* 日程管理 实体类
*
**/
public class Plan {
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

    private Date ondate;

	public Date getOndate() {
        return ondate;
    }

    public void setOndate(Date ondate) {
        this.ondate = ondate;
    }

    private Integer preuserid;

	public Integer getPreuserid() {
        return preuserid;
    }

    public void setPreuserid(Integer preuserid) {
        this.preuserid = preuserid;
    }

}