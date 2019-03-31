package com.ognice.domain;

import java.util.Date;
/**
*
* 用户管理 实体类
*
**/
public class Preuser {
    private Integer id;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String username;

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String name;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String psw;

	public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    private Integer apartmentid;

	public Integer getApartmentid() {
        return apartmentid;
    }

    public void setApartmentid(Integer apartmentid) {
        this.apartmentid = apartmentid;
    }

    private Integer jueseid;

	public Integer getJueseid() {
        return jueseid;
    }

    public void setJueseid(Integer jueseid) {
        this.jueseid = jueseid;
    }

    private String juesename;

	public String getJuesename() {
        return juesename;
    }

    public void setJuesename(String juesename) {
        this.juesename = juesename;
    }

    private String apartmentname;

	public String getApartmentname() {
        return apartmentname;
    }

    public void setApartmentname(String apartmentname) {
        this.apartmentname = apartmentname;
    }

}