/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.enums.admin;

/**
 * @EnumName AuthEnum
 * @Description TODO
 * @Author wangjian
 * @Date 2020/12/31 16:29
 */
public enum AuthEnum {
    普通管理员(0),
    总经理(1),
    老板(2);

    private Integer auth;

    AuthEnum(Integer auth) {
        this.auth = auth;
    }
}