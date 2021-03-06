package com.wj.driving.controller.drivercomment;

import com.wj.driving.restfulapi.dto.drivercomment.DriverCommentDetailsDTO;
import com.wj.driving.restfulapi.request.driver.DriverCommentRequest;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.result.BaseResult;
import com.wj.driving.service.drivercomment.DriverCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  用户评价
 * </p>
 *
 * @author wangjian
 * @since 2021/4/28
 */
@RestController
@RequestMapping("/drivercomment")
public class DriverCommentControlelr {

    @Autowired
    private DriverCommentService driverCommentService;

    @RequestMapping("/selectPage")
    public BaseResult getCommentList(@RequestBody DriverCommentRequest request){
        PageResult<DriverCommentDetailsDTO> commentList = driverCommentService.getCommentList(request);
        return BaseResult.getSuccessResult(commentList);
    }
}