package com.wang.sell.service.impl;

import com.wang.sell.DTO.OrderDTO;
import com.wang.sell.enums.ResultEnum;
import com.wang.sell.exception.SellException;
import com.wang.sell.service.BuyerService;
import com.wang.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderid) {

        return checkOrderOwner(openid, orderid);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderid) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderid);
        if(orderDTO == null){
            log.error("【取消订单】订单不存在，orderid={}",openid);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderid){
        OrderDTO orderDTO = orderService.findOne(orderid);
        if(orderDTO ==null){
            return null;
        }
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】openid不一致，请检查，openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
