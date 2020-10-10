package com.ainilzb.service.impl.center;

import com.ainilzb.enums.OrderStatusEnum;
import com.ainilzb.enums.YesOrNo;
import com.ainilzb.mapper.OrderStatusMapper;
import com.ainilzb.mapper.OrdersMapper;
import com.ainilzb.mapper.OrdersMapperCustom;
import com.ainilzb.pojo.OrderStatus;
import com.ainilzb.pojo.Orders;
import com.ainilzb.pojo.vo.center.MyOrdersVO;
import com.ainilzb.service.center.MyOrdersService;
import com.ainilzb.utils.PagedGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyOrdersServiceImpl implements MyOrdersService {

    @Autowired
    private OrdersMapperCustom ordersMapperCustom;
    @Autowired
    private OrderStatusMapper orderStatusMapper;
    @Autowired
    private OrdersMapper ordersMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult queryMyOrders(String userId,
                                         Integer orderStatus,
                                         Integer page,
                                         Integer pageSize) {

        Map<String, Object> map = new HashMap<>();
        map.put("userId",userId);
        if(orderStatus != null){
            map.put("orderStatus",orderStatus);
        }

        PageHelper.startPage(page,pageSize);
        List<MyOrdersVO> list = ordersMapperCustom.queryMyOrders(map);


        return setterPagedGrid(list,page);
    }

    private PagedGridResult setterPagedGrid(List<?> list,Integer page){
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateDeliverOrderStatus(String orderId){
        OrderStatus updateOrder = new OrderStatus();
        updateOrder.setOrderStatus(OrderStatusEnum.WAIT_RECEIVE.type);
        updateOrder.setDeliverTime(new Date());

        Example example = new Example(OrderStatus.class);
        Example.Criteria criteria =example.createCriteria();
        criteria.andEqualTo("orderId",orderId);
        //条件中，只有已付款，未发货的才能发货
        criteria.andEqualTo("orderStatus",OrderStatusEnum.WAIT_DELIVER.type);

        orderStatusMapper.updateByExampleSelective(updateOrder,example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Orders queryMyOrder(String userId, String orderId) {

        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setId(orderId);
        orders.setIsDelete(YesOrNo.NO.type);

        return ordersMapper.selectOne(orders);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateReceiverOrderStatus(String orderId) {
        OrderStatus updateOrder = new OrderStatus();
        updateOrder.setOrderStatus(OrderStatusEnum.SUCCESS.type);
        updateOrder.setSuccessTime(new Date());

        Example example = new Example(OrderStatus.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId",orderId);
        criteria.andEqualTo("orderStatus",OrderStatusEnum.WAIT_RECEIVE.type);

        int result = orderStatusMapper.updateByExampleSelective(updateOrder,example);
        return result == 1 ? true : false;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteOrder(String userId, String orderId) {
        Orders updateOrder = new Orders();
        updateOrder.setIsDelete(YesOrNo.YES.type);
        updateOrder.setUpdatedTime(new Date());

        Example example = new Example(Orders.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",orderId);
        criteria.andEqualTo("userId",userId);

        int result = ordersMapper.updateByExampleSelective(updateOrder,example);

        return result == 1 ? true : false;
    }


}
