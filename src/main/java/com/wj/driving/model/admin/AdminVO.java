package com.wj.driving.model.admin;


import com.wj.driving.restfulapi.enums.admin.AuthEnum;

import java.io.Serializable;

public class AdminVO implements Serializable {
    private Long id;
    private String account;
    private String name;
    private AuthEnum auth;

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

    public AuthEnum getAuth() {
        return auth;
    }

    public void setAuth(AuthEnum auth) {
        this.auth = auth;
    }
}
