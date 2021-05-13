package com.wj.driving.service.homepage;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.restfulapi.dto.homepage.HomePageDTO;
import com.wj.driving.restfulapi.service.homepage.IHomePageService;
import org.springframework.stereotype.Service;

@Service
public class HomePageService {

    @Reference
    private IHomePageService homePageService;

    public HomePageDTO getHomePageData(){
        return homePageService.getHomePageData();
    }
}
