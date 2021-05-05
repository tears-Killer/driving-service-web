package com.wj.driving.controller.userorder;

import com.wj.driving.restfulapi.dto.userorder.OrderDetailsDTO;
import com.wj.driving.restfulapi.request.userorder.UserOrderRequestSearch;
import com.wj.driving.restfulapi.result.PageResult;
import com.wj.driving.result.BaseResult;
import com.wj.driving.service.userorder.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  订单业务
 * </p>
 *
 * @author wangjian
 * @since 2021/4/21
 */
@CrossOrigin(origins = "http://localhost:8888")
@RestController
@RequestMapping(value = "/userOrder")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping(value = "/selectPage")
    public BaseResult getOrderList(@RequestBody UserOrderRequestSearch request){
        PageResult<OrderDetailsDTO> pageResult = userOrderService.selectPage(request);
        return BaseResult.getSuccessResult(pageResult);
    }

    @PostMapping(value = "/update")
    public BaseResult updateOrderInfo(@RequestBody OrderDetailsDTO orderDetailsDTO){
        int result = userOrderService.updateOrderInfo(orderDetailsDTO);
        if(result>0){
            return BaseResult.getSuccessResult();
        }
        return BaseResult.getFailedResult("修改订单信息失败");
    }
}