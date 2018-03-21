package com.spring.wvk.repository;

import com.spring.wvk.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("first");
        productInfo.setProductName("老友粉");
        productInfo.setProductPrice(new BigDecimal(16.00));
        productInfo.setCategoryType(19);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的粉");
        productInfo.setProductIcon("www.12306.com");
        productInfo.setProductStatus(0);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() throws Exception{

    }

}