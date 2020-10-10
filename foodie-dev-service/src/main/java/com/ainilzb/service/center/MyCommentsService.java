package com.ainilzb.service.center;

import com.ainilzb.pojo.OrderItems;

import java.util.List;

public interface MyCommentsService {
    /*
     * 根据订单id查询关联的商品
     * */
    public List<OrderItems> queryPending(String orderId);



}
