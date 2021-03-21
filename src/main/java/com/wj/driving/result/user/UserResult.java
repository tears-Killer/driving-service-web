package com.wj.driving.result.user;

import com.wj.driving.restfulapi.dto.user.UserDTO;

import java.util.List;

public class UserResult {

    private List<UserDTO> list;

    public List<UserDTO> getList() {
        return list;
    }

    public void setList(List<UserDTO> list) {
        this.list = list;
    }
}
