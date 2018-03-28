package com.spring.wvk.service.imp;

import com.spring.wvk.dataobject.OrderDetail;
import com.spring.wvk.dto.OrderDTO;
import com.spring.wvk.enums.OrderStatusEnum;
import com.spring.wvk.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImpTest {

    @Autowired
    private OrderServiceImp orderServiceImp;

    private final String BUYER_OPENID = "123321";
    private final String ORDER_ID = "152181774410713762";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小师傅");
        orderDTO.setBuyerAddress("青山路");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("12345678915");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("first");
        o1.setProductQuantity(1);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("four");
        o2.setProductQuantity(3);
        OrderDetail o3 = new OrderDetail();
        o3.setProductId("six");
        o3.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDetailList.add(o3);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderServiceImp.create(orderDTO);
        log.info("创建订单 result = {}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderServiceImp.findList(pageRequest);
        //Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
        Assert.assertTrue("查询所有订单列表",orderDTOPage.getTotalElements() > 0);
    }

    @Test
    public void cancle() {
        OrderDTO orderDTO = orderServiceImp.findOne(ORDER_ID);
        OrderDTO result = orderServiceImp.cancle(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCLE.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderServiceImp.findOne("152181710165380947");
        OrderDTO result = orderServiceImp.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderServiceImp.findOne("152181723299298287");
        OrderDTO result = orderServiceImp.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}