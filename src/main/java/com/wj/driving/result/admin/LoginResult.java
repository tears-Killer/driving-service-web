/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.result.admin;


import com.wj.driving.model.admin.AdminVO;

/**
 * @ClassName LoginResult
 * @Description TODO
 * @Author wangjain
 * @Date 2020/12/28 14:07
 */
public class LoginResult{

    private AdminVO adminVO;

    private String token;

    public AdminVO getAdminVO() {
        return adminVO;
    }

    public void setAdminVO(AdminVO adminVO) {
        this.adminVO = adminVO;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}