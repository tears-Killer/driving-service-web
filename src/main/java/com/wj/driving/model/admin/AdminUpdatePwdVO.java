/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.model.admin;

/**
 * @ClassName AdminUpdatePwdVO
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/7 14:13
 */
public class AdminUpdatePwdVO {

    private Long id;

    private String oldPassword;

    private String newPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}