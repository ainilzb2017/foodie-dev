package com.ainilzb.service.center;

import com.ainilzb.pojo.Orders;
import com.ainilzb.utils.PagedGridResult;

public interface MyOrdersService {
    /*
     * 查询我的订单列表
     * */
    public PagedGridResult queryMyOrders(String userId,
                                         Integer orderStatus,
                                         Integer page,
                                         Integer pageSize);


    /*
     * 订单状态 变成 商家发货
     * */
    public void updateDeliverOrderStatus(String orderId);


    /*
     * 查询我的订单
     * */
    public Orders queryMyOrder(String userId, String orderId);


    /*
     * 更新订单状态  确认收货
     * */
    public boolean updateReceiverOrderStatus(String orderId);

    /*
     * 更新订单状态  删除订单（逻辑删除）
     * */
    public boolean deleteOrder(String userId,String orderId);

}
