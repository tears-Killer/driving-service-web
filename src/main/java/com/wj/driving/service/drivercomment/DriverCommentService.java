package com.wj.driving.service.drivercomment;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.restfulapi.dto.drivercomment.DriverCommentDetailsDTO;
import com.wj.driving.restfulapi.request.DriverCommentRequest;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.restfulapi.service.drivercomment.IDriverCommentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  用户评价
 * </p>
 *
 * @author wangjian
 * @since 2021/4/28
 */
@Service
public class DriverCommentService {

    @Reference
    private IDriverCommentService driverCommentService;

    public PageResult<DriverCommentDetailsDTO> getCommentList(DriverCommentRequest request){
        PageResult<DriverCommentDetailsDTO> pageResult = driverCommentService.selectPagee(request);
        return pageResult;
    }
}