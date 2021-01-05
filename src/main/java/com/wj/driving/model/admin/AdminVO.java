package com.wj.driving.model.admin;


import com.wj.driving.restfulapi.enums.admin.AuthEnum;

import java.io.Serializable;

public class AdminVO implements Serializable {
    private Long id;
    private String phone;
    private String sex;
    private Integer age;
    private String name;
    private AuthEnum auth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
