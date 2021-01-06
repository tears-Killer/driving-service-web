package com.wj.driving.controller.admin;

import com.wj.driving.restfulapi.dto.admin.AdminLoginDTO;
import com.wj.driving.result.BaseResult;
import com.wj.driving.result.admin.LoginResult;
import com.wj.driving.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/admin")
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @RequestMapping(value = "/login")
    public BaseResult checkLogin(@RequestBody AdminLoginDTO admin){
        LoginResult result = adminLoginService.checkLogin(admin);
        if(result==null){
          return BaseResult.getFailedResult("登陆验证失败");
        }
        return BaseResult.getSuccessResult(result);
    }
}
