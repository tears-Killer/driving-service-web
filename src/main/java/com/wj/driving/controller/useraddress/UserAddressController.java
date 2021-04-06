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
@CrossOrigin(origins = "http://localhost:8888")
@RestController
@RequestMapping(value = "/useraddress")
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
        System.out.println(userAddressDTO.getUserId());
        List<UserAddressDTO> commonlyAddressList = userAddressService.getCommonlyAddressList(userAddressDTO);
        return BaseResult.getSuccessResult(commonlyAddressList);
    }
}