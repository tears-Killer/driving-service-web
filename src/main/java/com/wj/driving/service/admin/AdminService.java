/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.service.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.model.admin.AdminVO;
import com.wj.driving.restfulapi.dto.admin.AdminDetailsDTO;
import com.wj.driving.restfulapi.service.bizadmin.BizAdminService;
import com.wj.driving.result.admin.AdminResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/5 11:54
 */
@Service
public class AdminService {

    @Reference
    private BizAdminService bizAdminService;

    public AdminResult getAllAdmin(){
        List<AdminDetailsDTO> adminDTOList = bizAdminService.getAllAdmin();
        AdminResult result = new AdminResult();
        if(adminDTOList!=null) {
            List<AdminVO> adminVOList = adminDTOList.stream().map(item -> {
                AdminVO adminVO = new AdminVO();
                adminVO.setId(item.getId());
                adminVO.setPhone(item.getPhone());
                adminVO.setSex(item.getSex());
                adminVO.setAge(item.getAge());
                adminVO.setName(item.getName());
                adminVO.setAuth(item.getAuth());
                return adminVO;
            }).collect(Collectors.toList());
            result.setAdminVOList(adminVOList);
            return result;
        }
        return null;
    }

    public int addAdmin(AdminDetailsDTO adminDTO){
        return bizAdminService.addAdmin(adminDTO);
    }

    public int updateAdmin(AdminDetailsDTO adminDTO){
        return bizAdminService.updateAdmin(adminDTO);
    }
}