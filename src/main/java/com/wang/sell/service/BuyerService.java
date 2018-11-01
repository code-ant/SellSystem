package com.wang.sell.service;

import com.wang.sell.DTO.OrderDTO;
import org.springframework.util.StringUtils;

public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderid);
    //取消订单
    OrderDTO cancelOrder(String openid, String orderid);
}
