package com.wj.driving.result.user;

import com.wj.driving.restfulapi.dto.user.UserDTO;

import java.util.List;

public class UserResult {

    private List<UserDTO> list;

    private Integer totalCount;

    public List<UserDTO> getList() {
        return list;
    }

    public void setList(List<UserDTO> list) {
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
