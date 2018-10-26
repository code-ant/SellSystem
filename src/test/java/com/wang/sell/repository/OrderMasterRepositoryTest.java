package com.wang.sell.repository;

import com.wang.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "111";

    @Test
    public void findByBuyerOpenid() {

        PageRequest request = PageRequest.of(0, 2);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345");
        orderMaster.setBuyerName("wang");
        orderMaster.setBuyerPhone("12312312300");
        orderMaster.setBuyerAddress("000");
        orderMaster.setBuyerOpenid("111");
        orderMaster.setOrderAmount(new BigDecimal(23));

        OrderMaster resule = repository.save(orderMaster);
        Assert.assertNotNull(resule);
    }
}