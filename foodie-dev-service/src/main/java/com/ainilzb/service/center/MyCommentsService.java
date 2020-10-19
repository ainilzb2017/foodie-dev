package com.ainilzb.service.center;

import com.ainilzb.pojo.OrderItems;
import com.ainilzb.pojo.bo.center.OrderItemsCommentBO;
import com.ainilzb.utils.PagedGridResult;

import java.util.List;

public interface MyCommentsService {
    /*
     * 根据订单id查询关联的商品
     * */
    public List<OrderItems> queryPendingComment(String orderId);

    /*
     * 保存用户的评论
     * */
    public void saveComments(String orderId,String userId,List<OrderItemsCommentBO> commentList);

    /*
     * 我的评价查询分页
     * */
    public PagedGridResult queryMyComments(String userId, Integer page,Integer pageSize);



}
