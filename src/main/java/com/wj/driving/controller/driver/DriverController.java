package com.wj.driving.controller.driver;

import com.wj.driving.restfulapi.dto.driver.DriverAuditDTO;
import com.wj.driving.restfulapi.dto.driver.DriverDetailsDTO;
import com.wj.driving.restfulapi.request.driver.DriverRequestSearch;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.result.BaseResult;
import com.wj.driving.service.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  代驾管理
 * </p>
 *
 * @author wangjian
 * @since 2021/4/27
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "selectPage",method = RequestMethod.POST)
    public BaseResult getDriverList(@RequestBody DriverRequestSearch requestSearch){
        PageResult<DriverDetailsDTO> driverList = driverService.getDriverList(requestSearch);
        return BaseResult.getSuccessResult(driverList);
    }

    @PostMapping(value = "/updateState")
    public BaseResult updateDriverState(@RequestBody DriverDetailsDTO dto){
        int result = driverService.updateDriverState(dto);
        if(result>0){
            return BaseResult.getSuccessResult();
        }
        return BaseResult.getFailedResult("修改状态失败");
    }

    @PostMapping(value = "/auditList")
    public BaseResult getAuditList(@RequestBody DriverRequestSearch requestSearch){
        PageResult<DriverAuditDTO> auditList = driverService.waitAuditList(requestSearch);
        return BaseResult.getSuccessResult(auditList);
    }

    @PostMapping(value = "/approved")
    public BaseResult auditApproved(@RequestBody DriverAuditDTO auditDTO){
        int result = driverService.auditApproved(auditDTO);
        if(result>0){
            return BaseResult.getSuccessResult();
        }
        return BaseResult.getFailedResult("审核失败");
    }

    @PostMapping(value = "/refused")
    public BaseResult auditRefused(@RequestBody DriverAuditDTO auditDTO){
        int result = driverService.auditRefused(auditDTO);
        if(result>0){
            return BaseResult.getSuccessResult();
        }
        return BaseResult.getFailedResult("审核失败");
    }
}