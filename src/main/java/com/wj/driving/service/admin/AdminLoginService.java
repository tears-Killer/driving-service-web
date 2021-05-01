package com.wj.driving.service.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.model.admin.AdminVO;
import com.wj.driving.restfulapi.dto.admin.AdminDetailsDTO;
import com.wj.driving.restfulapi.dto.admin.AdminLoginDTO;
import com.wj.driving.restfulapi.enums.admin.AuthEnum;
import com.wj.driving.restfulapi.service.bizadmin.BizAdminLoginService;
import com.wj.driving.result.admin.LoginResult;
import com.wj.driving.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminLoginService {

    private static final Logger log = LoggerFactory.getLogger(AdminLoginService.class);

    @Reference
    private BizAdminLoginService bizAdminLoginService;

    @Autowired
    private RedisUtil redisUtil;

    public LoginResult checkLogin(AdminLoginDTO admin){
            AdminDetailsDTO adminDTO = bizAdminLoginService.checkLogin(admin);
            if (adminDTO != null) {
                AdminVO adminVO = new AdminVO();
                adminVO.setId(adminDTO.getId());
                adminVO.setPhone(adminDTO.getPhone());
                adminVO.setSex(adminDTO.getSex());
                adminVO.setAge(adminDTO.getAge());
                adminVO.setName(adminDTO.getName());
                adminVO.setAuth(adminDTO.getAuth());
                adminVO.setAuthName(AuthEnum.getSourceType(adminDTO.getAuth()));
                String token = UUID.randomUUID().toString();
                log.info("-----token:{}",token);
                redisUtil.hset(token, "id", adminVO.getId(), 60*60);
                LoginResult result = new LoginResult();
                result.setAdminVO(adminVO);
                result.setToken(token);
                return result;
            }
        return null;
    }
}
