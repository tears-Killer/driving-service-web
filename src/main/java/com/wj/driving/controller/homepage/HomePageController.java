package com.wj.driving.controller.homepage;


import com.wj.driving.restfulapi.dto.homepage.HomePageDTO;
import com.wj.driving.result.BaseResult;
import com.wj.driving.service.homepage.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/homePage")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    @PostMapping(value = "/getData")
    public BaseResult getHomePageData(){
        HomePageDTO homePageData = homePageService.getHomePageData();
        if(Objects.isNull(homePageData)){
            return BaseResult.getFailedResult("获取数据失败");
        }
        return BaseResult.getSuccessResult(homePageData);
    }
}
