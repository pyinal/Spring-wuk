package com.spring.wvk.repository;

import com.spring.wvk.dataobject.OrderMaster;
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

    @Test
    public void saveTest(){
        OrderMaster orderMaster =new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerName("gghaha");
        orderMaster.setBuyerPhone("52345687977");
        orderMaster.setBuyerAddress("mk");
        orderMaster.setBuyerOpenid("611212");
        orderMaster.setOrderAmount(new BigDecimal(3.92));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);

    }
    @Test
    public void findByBuyerOpenid() throws Exception{
        PageRequest request = new PageRequest(0,3);
        Page<OrderMaster> result = repository.findByBuyerOpenid("211212",request);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}