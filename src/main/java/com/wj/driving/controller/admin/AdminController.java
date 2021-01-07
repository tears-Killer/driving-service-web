package com.wj.driving.controller.admin;

import com.wj.driving.exceptions.MessageErrorCode;
import com.wj.driving.restfulapi.dto.admin.AdminDetailsDTO;
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
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/getall",method = RequestMethod.POST)
    public BaseResult getAllAdmin(){
        AdminResult result = adminService.getAllAdmin();
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
}