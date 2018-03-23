package com.spring.wvk.repository;

import com.spring.wvk.dataobject.OrderDetail;
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
        OrderDetail orderDetail =new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setOrderId("123");
        orderDetail.setProductIcon("www.icon.com");
        orderDetail.setProductName("water fish");
        orderDetail.setProductId("12");
        orderDetail.setProductPrice(new BigDecimal(6.65));
        orderDetail.setProductQuantity(65);
        repository.save(orderDetail);
    }
    @Test
    public void findByOrderId()throws Exception{
        List<OrderDetail>result = repository.findByOrderId("123");
        Assert.assertNotNull(result);
    }

}