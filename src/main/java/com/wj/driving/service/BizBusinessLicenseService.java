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


    public String getBusinessLicenseInfo(MultipartFile file) throws IOException {
        String path = "D:/photos/";
        String fileName = file.getOriginalFilename();
        byte[] data = null;
        File targetFile = new File(path);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File saveFile = new File(targetFile, fileName);
        file.transferTo(saveFile);
        try (InputStream in = new FileInputStream(path)) {
            data = new byte[in.available()];
            in.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回Base64编码过的字节数组字符串
        System.out.println("本地图片转换Base64: ");
        System.out.println(Base64.getEncoder().encodeToString(data));
        String s = Base64.getEncoder().encodeToString(data);
        String resultStr = TencentCloudApiUtil.setImageBase64(null, s);
        System.out.println(resultStr);
        return resultStr;

    }

}