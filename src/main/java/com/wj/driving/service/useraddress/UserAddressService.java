/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.service.useraddress;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.restfulapi.dto.useraddress.UserAddressDTO;
import com.wj.driving.restfulapi.request.useraddress.UserAddressRequestSearch;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.restfulapi.service.useraddress.IUserAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName useraddress
 * @Description 客户目的地管理
 * @Author wangjian
 * @Date 2021/4/2 14:22
 */
@Service
public class UserAddressService {

    @Reference
    private IUserAddressService userAddressService;

    public PageResult<UserAddressDTO> getUserAddressList(UserAddressRequestSearch request){
       return userAddressService.selectPage(request);
    }

    public List<UserAddressDTO> getCommonlyAddressList(UserAddressDTO userAddressDTO){
        return userAddressService.getcommonlyAddressList(userAddressDTO);
    }

}