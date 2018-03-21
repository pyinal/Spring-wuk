package com.spring.wvk.service.imp;

import com.spring.wvk.dataobject.ProductInfo;
import com.spring.wvk.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImpTest {

    @Autowired
    private ProductServiceImp productServiceImp;

    @Test
    public void findOne() {
        ProductInfo productInfo = productServiceImp.findOne("first");
        Assert.assertEquals("first",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfos = productServiceImp.findUpAll();
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfos = productServiceImp.findAll(request);
        //System.out.println(productInfos.getTotalElements());
        Assert.assertNotEquals(0,productInfos.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("seconde");
        productInfo.setProductName("蛋炒饭");
        productInfo.setProductPrice(new BigDecimal(8.10));
        productInfo.setCategoryType(3);
        productInfo.setProductStock(110);
        productInfo.setProductDescription("很多蛋的饭");
        productInfo.setProductIcon("www.12308.com");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        ProductInfo result = productServiceImp.save(productInfo);
        Assert.assertNotNull(result);
    }
}