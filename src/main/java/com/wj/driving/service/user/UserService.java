package com.wj.driving.service.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.restfulapi.dto.user.UserDTO;
import com.wj.driving.restfulapi.request.user.UserRequestSearch;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.restfulapi.service.user.IUserService;
import com.wj.driving.result.user.UserResult;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    private IUserService userService;

    public UserResult getUserList(UserRequestSearch request){
        UserResult result = new UserResult();
        PageResult<UserDTO> pageResult = userService.getUserList(request);
        result.setList(pageResult.getList());
        result.setTotalCount(pageResult.getTotalCount());
        return result;
    }

    public int updateUserInfo(UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    public int updateUserState(UserDTO userDTO){
        return userService.updateUserState(userDTO);
    }
}
