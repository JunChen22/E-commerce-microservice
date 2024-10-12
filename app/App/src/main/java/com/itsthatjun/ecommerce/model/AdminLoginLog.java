package com.itsthatjun.ecommerce.model;

import java.io.Serializable;
import java.util.Date;

public class AdminLoginLog implements Serializable {
    private Integer id;

    private Integer adminId;

    private Date loginTime;

    private String ipAddress;

    private Integer userAgent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(Integer userAgent) {
        this.userAgent = userAgent;
    }
}