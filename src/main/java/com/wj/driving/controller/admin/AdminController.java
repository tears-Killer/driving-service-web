/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.controller.admin;

import com.wj.driving.restfulapi.dto.admin.AdminDetailsDTO;
import com.wj.driving.result.Result;
import com.wj.driving.result.admin.AdminResult;
import com.wj.driving.service.admin.AdminService;
import com.wj.driving.util.ResultUtil;
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
    public Result getAllAdmin(){
        AdminResult result = adminService.getAllAdmin();
        if(result!=null){
            return ResultUtil.success(result);
        }
        return ResultUtil.fail("查询失败");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result addAdmin(@RequestBody AdminDetailsDTO adminDTO){
        int result = adminService.addAdmin(adminDTO);
        if(result>0){
           return ResultUtil.success(result);
        }
        return ResultUtil.fail("添加失败");
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result updateAdmin(@RequestBody AdminDetailsDTO adminDTO){
        int result = adminService.updateAdmin(adminDTO);
        if(result>0){
            return ResultUtil.success(result);
        }
        return ResultUtil.fail("修改失败");
    }
}