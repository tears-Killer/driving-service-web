package com.wj.driving.service.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.restfulapi.dto.user.UserDTO;
import com.wj.driving.restfulapi.service.user.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Reference
    private IUserService userService;

    public List<UserDTO> getUserList(){
        return userService.getUserList();
    }
}
