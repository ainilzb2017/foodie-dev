package com.ainilzb.service.impl.center;

import com.ainilzb.mapper.OrderItemsMapper;
import com.ainilzb.mapper.UsersMapper;
import com.ainilzb.pojo.OrderItems;
import com.ainilzb.pojo.Users;
import com.ainilzb.pojo.bo.center.CenterUserBO;
import com.ainilzb.service.center.CenterUserService;
import com.ainilzb.service.center.MyCommentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MyCommentsServiceImpl implements MyCommentsService {

    @Autowired
    public OrderItemsMapper orderItemsMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<OrderItems> queryPending(String orderId) {
        OrderItems query = new OrderItems();
        query.setOrderId(orderId);
        return orderItemsMapper.select(query);
    }





}
