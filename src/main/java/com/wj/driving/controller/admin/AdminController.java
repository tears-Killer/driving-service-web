package com.wj.driving.controller.admin;

import com.wj.driving.exceptions.MessageErrorCode;
import com.wj.driving.model.admin.AdminUpdatePwdVO;
import com.wj.driving.restfulapi.dto.admin.AdminDetailsDTO;
import com.wj.driving.restfulapi.request.admin.AdminRequestSearch;
import com.wj.driving.result.BaseResult;
import com.wj.driving.result.admin.AdminResult;
import com.wj.driving.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/5 13:49
 */
@CrossOrigin(origins = "http://localhost:8888")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/getall",method = RequestMethod.POST)
    public BaseResult getAllAdmin(@RequestBody AdminRequestSearch request){
        AdminResult result = adminService.getAllAdmin(request);
        if(result!=null){
            return BaseResult.getSuccessResult(result);
        }
        return BaseResult.getFailedResult(MessageErrorCode.操作失败);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResult addAdmin(@RequestBody AdminDetailsDTO adminDTO){
        int result = adminService.addAdmin(adminDTO);
        if(result>0){
            return BaseResult.getSuccessResult(result);
        }
        return BaseResult.getFailedResult(MessageErrorCode.操作失败);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResult updateAdmin(@RequestBody AdminDetailsDTO adminDTO){
        int result = adminService.updateAdmin(adminDTO);
        if(result>0){
            return BaseResult.getSuccessResult(result);
        }
        return BaseResult.getFailedResult(MessageErrorCode.操作失败);
    }

    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    public BaseResult updateAdminPassword(@RequestBody AdminUpdatePwdVO adminUpdatePwdVO){
        int result = adminService.updateAdminPWD(adminUpdatePwdVO);
        if(result>0){
            return BaseResult.getSuccessResult(result);
        }
        return BaseResult.getFailedResult(MessageErrorCode.密码修改失败);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public BaseResult deleteAdmin(@RequestBody AdminDetailsDTO adminDTO){
        int result = adminService.deleteAdmin(adminDTO.getId());
        if(result>0){
            return BaseResult.getSuccessResult(result);
        }
        return BaseResult.getFailedResult(MessageErrorCode.操作失败);
    }
}