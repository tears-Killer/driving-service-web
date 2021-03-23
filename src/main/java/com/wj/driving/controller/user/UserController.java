package com.wj.driving.controller.user;

import com.wj.driving.restfulapi.dto.user.UserDTO;
import com.wj.driving.result.BaseResult;
import com.wj.driving.result.user.UserResult;
import com.wj.driving.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8888")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/selectPage")
    public BaseResult getUserList(){
        UserResult result = userService.getUserList();
        return BaseResult.getSuccessResult(result);
    }
}