package com.wj.driving.controller.user;

import com.wj.driving.restfulapi.request.user.UserRequestSearch;
import com.wj.driving.result.BaseResult;
import com.wj.driving.result.user.UserResult;
import com.wj.driving.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
