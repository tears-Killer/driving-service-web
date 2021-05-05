package com.wj.driving.controller.driver;

import com.wj.driving.restfulapi.dto.driver.DriverDetailsDTO;
import com.wj.driving.restfulapi.request.driver.DriverRequestSearch;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.result.BaseResult;
import com.wj.driving.service.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}