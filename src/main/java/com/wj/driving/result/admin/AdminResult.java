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

    private List<AdminVO> list;

    private Integer totalCount;

    public List<AdminVO> getList() {
        return list;
    }

    public void setList(List<AdminVO> list) {
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}