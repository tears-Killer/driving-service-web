/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.result.admin;

import com.wj.driving.model.admin.AdminVO;

import java.util.List;

/**
 * @ClassName AdminResult
 * @Description TODO
 * @Author wangjian
 * @Date 2020/12/31 14:17
 */
public class AdminResult {

    List<AdminVO> adminVOList;

    public List<AdminVO> getAdminVOList() {
        return adminVOList;
    }

    public void setAdminVOList(List<AdminVO> adminVOList) {
        this.adminVOList = adminVOList;
    }
}