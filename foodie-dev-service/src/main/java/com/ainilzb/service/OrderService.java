package com.ainilzb.service;

import com.ainilzb.pojo.Carousel;
import com.ainilzb.pojo.OrderStatus;
import com.ainilzb.pojo.bo.SubmitOrderBo;
import com.ainilzb.pojo.vo.OrderVO;

import java.util.List;

public interface OrderService {
    /*
    * 用于创建订单相关信息
    * */
    public OrderVO createOrder(SubmitOrderBo submitOrderBo);

    /*
     * 修改订单状态
     * */
    public void updateOrderStatus(String orderId,Integer orderStatus);

    /*
     * 查询订单状态
     * */
    public OrderStatus queryOrderStatusInfo(String orderId);

    /*
     * 关闭超时未支付订单
     * */
    public void closeOrder();

}
