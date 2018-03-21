package com.spring.wvk.service.imp;

import com.spring.wvk.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImpTest {

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @Test
    public void findOne()throws Exception {
        ProductCategory productCategory = categoryServiceImp.findOne(6);
        Assert.assertEquals(new Integer(6),productCategory.getCategoryId());
    }

    @Test
    public void findAll()throws Exception {
        List<ProductCategory>productCategories = categoryServiceImp.findAll();
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void findByCategoryTypeIn()throws Exception {
        List<ProductCategory>productCategories = categoryServiceImp.findByCategoryTypeIn(Arrays.asList(2,3,5,6));
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void save()throws Exception {
        ProductCategory productCategory = new ProductCategory("男生专享",19);
        ProductCategory result = categoryServiceImp.save(productCategory);
        Assert.assertNotNull(result);
    }
}