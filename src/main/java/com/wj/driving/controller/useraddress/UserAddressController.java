/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.controller.useraddress;

import com.wj.driving.restfulapi.dto.useraddress.UserAddressDTO;
import com.wj.driving.restfulapi.request.useraddress.UserAddressRequestSearch;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.result.BaseResult;
import com.wj.driving.service.useraddress.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserAddressController
 * @Description 客户目的地管理
 * @Author wangjian
 * @Date 2021/4/2 14:25
 */
@RestController
@RequestMapping(value = "/userAddress")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @PostMapping(value = "/selectPage")
    public BaseResult selectPage(@RequestBody UserAddressRequestSearch request){
        PageResult<UserAddressDTO> result = userAddressService.getUserAddressList(request);
        return BaseResult.getSuccessResult(result);
    }

    @PostMapping(value = "/commonAddressList")
    public BaseResult getCommonAddressList(@RequestBody UserAddressDTO userAddressDTO){
        List<UserAddressDTO> commonlyAddressList = userAddressService.getCommonlyAddressList(userAddressDTO);
        return BaseResult.getSuccessResult(commonlyAddressList);
    }

    @PostMapping(value = "/setDefaultAddress")
    public BaseResult setDefaultAddress(@RequestBody UserAddressDTO userAddressDTO){
        userAddressService.setDefaultAddress(userAddressDTO);
        return BaseResult.getSuccessResult();
    }

    @PostMapping(value = "/deleteAddress")
    public BaseResult deleteAddress(@RequestBody UserAddressDTO userAddressDTO){
        userAddressService.deleteAddress(userAddressDTO);
        return BaseResult.getSuccessResult();
    }

}