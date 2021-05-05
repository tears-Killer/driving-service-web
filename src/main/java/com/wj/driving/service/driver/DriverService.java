package com.wj.driving.service.driver;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.restfulapi.dto.driver.DriverDetailsDTO;
import com.wj.driving.restfulapi.request.driver.DriverRequestSearch;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.restfulapi.service.driver.IDriverService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  代驾管理
 * </p>
 *
 * @author wangjian
 * @since 2021/4/27
 */
@Service
public class DriverService {

    @Reference
    private IDriverService driverService;

    public PageResult<DriverDetailsDTO> getDriverList(DriverRequestSearch requestSearch){
        PageResult<DriverDetailsDTO> result = driverService.selectPage(requestSearch);
        return result;
    }
}