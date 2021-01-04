package com.wj.driving.model.admin;

import com.wj.driving.restfulapi.enums.admin.AuthEnum;

import java.io.Serializable;

public class AdminVO implements Serializable {
    private Long id;
    private String account;
    private String name;
    private Integer auth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }
}
