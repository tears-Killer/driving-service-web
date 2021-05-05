package com.wj.driving.controller.user;

import com.wj.driving.restfulapi.dto.user.UserDTO;
import com.wj.driving.restfulapi.request.user.UserRequestSearch;
import com.wj.driving.result.BaseResult;
import com.wj.driving.result.user.UserResult;
import com.wj.driving.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/selectPage")
    public BaseResult getUserList(@RequestBody UserRequestSearch request){
        UserResult result = userService.getUserList(request);
        return BaseResult.getSuccessResult(result);
    }

    @PostMapping(value = "/update")
    public BaseResult updateUserInfo(@RequestBody UserDTO userDTO){
        int result = userService.updateUserInfo(userDTO);
        if(result>0){
            return BaseResult.getSuccessResult();
        }
        return BaseResult.getFailedResult("修改用户信息失败");
    }

    @PostMapping(value = "/updateState")
    public BaseResult updateUserState(@RequestBody UserDTO userDTO){
        int result = userService.updateUserState(userDTO);
        if(result>0){
            return BaseResult.getFailedResult("修改用户状态失败");
        }
        return BaseResult.getSuccessResult();
    }

}
