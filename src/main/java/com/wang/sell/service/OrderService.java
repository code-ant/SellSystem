package com.wang.sell.service;

import com.wang.sell.DTO.OrderDTO;
import com.wang.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderMaster);
    //查询单个
    OrderDTO findOne(String orderId);
    //订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);
    //完结订单
    OrderDTO finish(OrderDTO orderDTO);
    //支付订单
    OrderDTO paid(OrderDTO orderDTO);

}

