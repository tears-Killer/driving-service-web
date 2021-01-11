/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.controller;

import com.wj.driving.service.BizBusinessLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName BusinessLicenseController
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/11 15:01
 */
@Controller
public class BusinessLicenseController {

    @Autowired
    private BizBusinessLicenseService bizBusinessLicenseService;


    @RequestMapping(value = "/toupload")
    public String toUpload(){
        return "upload";
    }
    @RequestMapping(value = "/getlicense",method = RequestMethod.POST)
    @ResponseBody
    public String getBusinessLicenseInfo(MultipartFile file) throws IOException {
        String resultStr = bizBusinessLicenseService.getBusinessLicenseInfo(file);
        return resultStr;
    }
}