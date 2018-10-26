package com.wang.sell.repository;

import com.wang.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("124345");
        orderDetail.setOrderId("1243");
        orderDetail.setProductIcon("dddddd");
        orderDetail.setProductId("11411");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(22.2));
        orderDetail.setProductQuantity(34);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("123");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}