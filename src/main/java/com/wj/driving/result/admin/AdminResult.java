/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.result.admin;

import java.util.List;

/**
 * @ClassName AdminResult
 * @Description TODO
 * @Author wangjian
 * @Date 2020/12/31 14:17
 */
public class AdminResult {

    List<Object> adminBOList;

    public List<Object> getAdminBOList() {
        return adminBOList;
    }

    public void setAdminBOList(List<Object> adminBOList) {
        this.adminBOList = adminBOList;
    }

    @Override
    public String toString() {
        return "AdminResult{" +
                "adminBOList=" + adminBOList +
                '}';
    }
}