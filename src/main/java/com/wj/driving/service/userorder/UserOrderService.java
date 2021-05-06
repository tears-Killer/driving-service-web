package com.wj.driving.service.userorder;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.driving.restfulapi.dto.drivercomment.DriverCommentDetailsDTO;
import com.wj.driving.restfulapi.dto.userorder.OrderDetailsDTO;
import com.wj.driving.restfulapi.request.userorder.UserOrderRequestSearch;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.restfulapi.service.userorder.IUserOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  订单业务
 * </p>
 *
 * @author wangjian
 * @since 2021/4/21
 */
@Service
public class UserOrderService {

    @Reference
    private IUserOrderService userOrderService;

    public PageResult<OrderDetailsDTO> selectPage(UserOrderRequestSearch request){
        PageResult<OrderDetailsDTO> pageResult = userOrderService.selectPage(request);
        return pageResult;
    }

    public int updateOrderInfo(OrderDetailsDTO orderDetailsDTO){
        return userOrderService.updateOrderInfo(orderDetailsDTO);
    }

    public DriverCommentDetailsDTO getOrderComment(OrderDetailsDTO orderDetailsDTO){
        return userOrderService.findCommentById(orderDetailsDTO);
    }
}