package com.wj.driving.controller.admin;

import com.wj.driving.exceptions.MessageErrorCode;
import com.wj.driving.restfulapi.dto.admin.AdminLoginDTO;
import com.wj.driving.result.BaseResult;
import com.wj.driving.result.admin.LoginResult;
import com.wj.driving.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8888")
@RestController
@RequestMapping(value = "/admin")
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping(value = "/login")
    public BaseResult checkLogin(@RequestBody AdminLoginDTO admin){
        LoginResult result = adminLoginService.checkLogin(admin);
        if(result==null){
          return BaseResult.getFailedResult(MessageErrorCode.登陆验证失败);
        }
        return BaseResult.getSuccessResult(result);
    }
}
