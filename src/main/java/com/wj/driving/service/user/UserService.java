package com.wj.driving.service.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.restfulapi.dto.user.UserDTO;
import com.wj.driving.restfulapi.service.user.IUserService;
import com.wj.driving.result.user.UserResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Reference
    private IUserService userService;

    public UserResult getUserList(){
        UserResult result = new UserResult();
        List<UserDTO> userList = userService.getUserList();
        result.setList(userList);
        return result;
    }
}
