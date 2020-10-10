package com.ainilzb.controller.center;

import com.ainilzb.controller.BaseController;
import com.ainilzb.pojo.Orders;
import com.ainilzb.service.center.MyCommentsService;
import com.ainilzb.service.center.MyOrdersService;
import com.ainilzb.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户中心评价模块",tags = {"用户中心评价模块的相关接口"})
@RestController
@RequestMapping("/mycomments")
public class MyCommentsController extends BaseController {
    @Autowired
    private MyCommentsService myCommentsService;

    @Autowired
    private MyOrdersService myOrdersService;

    @ApiOperation(value = "查询订单列表",notes = "查询订单列表",httpMethod = "POST")
    @PostMapping("/pending")
    public IMOOCJSONResult pending(@ApiParam(name = "userId", value = "用户id",required = true) @RequestParam String userId,
                                  @ApiParam(name = "orderId", value = "订单id",required = true) @RequestParam String orderId){

        IMOOCJSONResult checkResult = checkUserOrder(userId,orderId);
        if(checkResult.getStatus() != HttpStatus.OK.value()){
            return checkResult;
        }
        return IMOOCJSONResult.ok();
    }




}
