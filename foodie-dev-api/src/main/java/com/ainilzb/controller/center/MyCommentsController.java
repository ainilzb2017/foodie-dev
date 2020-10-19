package com.ainilzb.controller.center;

import com.ainilzb.controller.BaseController;
import com.ainilzb.enums.YesOrNo;
import com.ainilzb.pojo.OrderItems;
import com.ainilzb.pojo.Orders;
import com.ainilzb.pojo.bo.center.OrderItemsCommentBO;
import com.ainilzb.service.center.MyCommentsService;
import com.ainilzb.service.center.MyOrdersService;
import com.ainilzb.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        //判断该笔订单是否已经评价过，评价过就不再继续
        Orders myOrder =  (Orders)checkResult.getData();
        if(myOrder.getIsComment() == YesOrNo.YES.type){
            return IMOOCJSONResult.errorMsg("该笔订单已经评价");
        }
        List<OrderItems> list = myCommentsService.queryPendingComment(orderId);
        return IMOOCJSONResult.ok(list);
    }

    @ApiOperation(value = "保存评论列表",notes = "保存评论列表",httpMethod = "POST")
    @PostMapping("/saveList")
    public IMOOCJSONResult saveList(@ApiParam(name = "userId", value = "用户id",required = true) @RequestParam String userId,
                                    @ApiParam(name = "orderId", value = "订单id",required = true) @RequestParam String orderId,
                                    @RequestBody List<OrderItemsCommentBO> commentList){

        System.out.println(commentList);

        //判断用户和订单是否关联
        IMOOCJSONResult checkResult = checkUserOrder(userId,orderId);
        if(checkResult.getStatus() != HttpStatus.OK.value()){
            return checkResult;
        }

        //判断评论内容list不能为空(一般写前两个即可）
        if(commentList == null || commentList.isEmpty() || commentList.size() == 0 ){
            return IMOOCJSONResult.errorMsg("评论内容不能为空");
        }

        myCommentsService.saveComments(orderId,userId,commentList);
        return IMOOCJSONResult.ok();
    }




}
