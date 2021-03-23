package com.wj.driving.service.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.model.admin.AdminUpdatePwdVO;
import com.wj.driving.model.admin.AdminVO;
import com.wj.driving.restfulapi.dto.admin.AdminDetailsDTO;
import com.wj.driving.restfulapi.enums.admin.AuthEnum;
import com.wj.driving.restfulapi.request.admin.AdminSearchRequest;
import com.wj.driving.restfulapi.service.bizadmin.BizAdminService;
import com.wj.driving.result.admin.AdminResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName AdminService
 * @Description
 * @Author wangjian
 * @Date 2021/1/5 11:54
 */
@Service
public class AdminService {

    @Reference
    private BizAdminService bizAdminService;

    public AdminResult getAllAdmin(AdminSearchRequest request){
        List<AdminDetailsDTO> adminDTOList = bizAdminService.getAllAdmin(request);
        AdminResult result = new AdminResult();
        if(adminDTOList!=null) {
            List<AdminVO> adminVOList = adminDTOList.stream().map(item -> {
                AdminVO adminVO  =new AdminVO();
                adminVO.setId(item.getId());
                adminVO.setPhone(item.getPhone());
                adminVO.setSex(item.getSex());
                adminVO.setAge(item.getAge());
                adminVO.setName(item.getName());
                adminVO.setIdCard(item.getIdCard());
                adminVO.setAuth(item.getAuth());
                adminVO.setAuthName(AuthEnum.getSourceType(adminVO.getAuth()));
                return adminVO;
            }).collect(Collectors.toList());
            result.setList(adminVOList);
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

    public int updateAdminPWD(AdminUpdatePwdVO adminUpdatePwdVO){
        AdminDetailsDTO adminDTO = new AdminDetailsDTO();
        adminDTO.setId(adminUpdatePwdVO.getId());
        adminDTO.setPassword(adminUpdatePwdVO.getOldPassword());
        return bizAdminService.updateAdminPWD(adminDTO,adminUpdatePwdVO.getNewPassword());
    }

    public int deleteAdmin(Long id){
        return bizAdminService.deleteAdmin(id);
    }

}