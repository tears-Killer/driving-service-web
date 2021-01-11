/**
 * Copyright 2017 武汉易酒批电子商务有限公司. All rights reserved.
 */
package com.wj.driving.util;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.BizLicenseOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.BizLicenseOCRResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName TencentCloudApiUtil
 * @Description TODO
 * @Author wangjian
 * @Date 2021/1/11 11:09
 */
public class TencentCloudApiUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(TencentCloudApiUtil.class);
    /**
     * 腾讯云访问密钥
     */
    @Value("${url.outside.tencentcloudsdk.secretId}")
    private static String secretId;

    @Value("${url.outside.tencentcloudsdk.secretKey}")
    private static String secretKey;

    public static String setImageUrl(String region,String imageUrl){
        try{
            OcrClient client = getOcrClient(region, secretId, secretKey);
            BizLicenseOCRRequest req = new BizLicenseOCRRequest();
            req.setImageUrl(imageUrl);

            BizLicenseOCRResponse resp = client.BizLicenseOCR(req);

            return BizLicenseOCRResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            LOGGER.warn("腾讯云营业执照识别错误",e);
        }
        return null;
    }

    public static String setImageBase64(String region,String imageBase64){
        try{
            OcrClient client = getOcrClient(region, secretId, secretKey);
            BizLicenseOCRRequest req = new BizLicenseOCRRequest();
            req.setImageBase64(imageBase64);

            BizLicenseOCRResponse resp = client.BizLicenseOCR(req);

            return BizLicenseOCRResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            LOGGER.warn("腾讯云营业执照识别错误",e);
        }
        return null;
    }

    private static OcrClient getOcrClient(String region,String secretId,String secretKey){
        Credential cred = new Credential(secretId,secretKey);

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("ocr.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        if(region==null){
            region = "ap-beijing";
        }

        OcrClient client = new OcrClient(cred, region, clientProfile);

        return client;
    }
}