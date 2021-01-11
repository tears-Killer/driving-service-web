/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.service;

import com.wj.driving.util.TencentCloudApiUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;


/**
 * @ClassName BizBusinessLicenseService
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/11 13:45
 */
@Service
public class BizBusinessLicenseService {


    public String getBusinessLicenseInfo(String imagePath) throws IOException {

        String resultStr = TencentCloudApiUtil.getBusinessLicenseInfo(imagePath);
        return resultStr;

    }

}