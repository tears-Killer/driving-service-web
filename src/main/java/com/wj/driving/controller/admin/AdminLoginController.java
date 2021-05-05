package com.wj.driving.controller.admin;

import com.wj.driving.exceptions.MessageErrorCode;
import com.wj.driving.restfulapi.dto.admin.AdminLoginDTO;
import com.wj.driving.result.BaseResult;
import com.wj.driving.result.admin.LoginResult;
import com.wj.driving.service.admin.AdminLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminLoginController {

    private static final Logger log = LoggerFactory.getLogger(AdminLoginController.class);

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
