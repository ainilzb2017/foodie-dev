package com.ainilzb.service.impl.center;

import com.ainilzb.enums.YesOrNo;
import com.ainilzb.mapper.ItemsCommentsMapperCustom;
import com.ainilzb.mapper.OrderItemsMapper;
import com.ainilzb.mapper.OrderStatusMapper;
import com.ainilzb.mapper.OrdersMapper;
import com.ainilzb.pojo.OrderItems;
import com.ainilzb.pojo.OrderStatus;
import com.ainilzb.pojo.Orders;
import com.ainilzb.pojo.bo.center.OrderItemsCommentBO;
import com.ainilzb.pojo.vo.center.MyCommentVO;
import com.ainilzb.service.center.MyCommentsService;
import com.ainilzb.utils.PagedGridResult;
import com.github.pagehelper.PageHelper;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyCommentsServiceImpl extends BaseService implements MyCommentsService {

    @Autowired
    public OrderItemsMapper orderItemsMapper;
    @Autowired
    public Sid sid;
    @Autowired
    public ItemsCommentsMapperCustom itemsCommentsMapperCustom;
    @Autowired
    public OrdersMapper ordersMapper;
    @Autowired
    public OrderStatusMapper orderStatusMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<OrderItems> queryPendingComment(String orderId) {
        OrderItems query = new OrderItems();
        query.setOrderId(orderId);
        return orderItemsMapper.select(query);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveComments(String orderId, String userId,
                             List<OrderItemsCommentBO> commentList) {
        //1.保存评价   items_comments
        for(OrderItemsCommentBO oic : commentList){
            //sid生成全局唯一数，这里是给id设值，也可以是设置数据库表自增，但是全局不唯一
            oic.setCommentId(sid.nextShort());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("commentList",commentList);
        itemsCommentsMapperCustom.saveComment(map);



        //2.修改订单表，改为已评价  orders
        Orders order = new Orders();
        order.setId(orderId);
        order.setIsComment(YesOrNo.YES.type);
        int yesorno =  ordersMapper.updateByPrimaryKeySelective(order);
        System.out.println(yesorno);

        //3.修改订单状态表的留言时间  order_status
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(orderId);
        orderStatus.setCommentTime(new Date());
        orderStatusMapper.updateByPrimaryKeySelective(orderStatus);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize) {
        //这种map写法，比较通用的写法
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        PageHelper.startPage(page,pageSize);

        List<MyCommentVO> list = itemsCommentsMapperCustom.queryMyComments(map);
        return setterPagedGrid(list,page);
    }


}
