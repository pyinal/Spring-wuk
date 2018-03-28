package com.spring.wvk.controller;

import com.spring.wvk.dataobject.ProductCategory;
import com.spring.wvk.dataobject.ProductInfo;
import com.spring.wvk.enums.ResultEnum;
import com.spring.wvk.exception.SellException;
import com.spring.wvk.service.CategoryService;
import com.spring.wvk.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
@Slf4j

public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "3") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list", map);
    }

    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String,Object>map){
        try {
            productService.offSale(productId);
        }catch (SellException e){
            log.error(e.getMessage());
            map.put("msg", "下架商品"+e.getMessage());
            map.put("url","/spring/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.PRODUCT_OFF_SALE_SUCCESS.getMessage());
        map.put("url","/spring/seller/product/list");
        return new ModelAndView("common/success");
    }

    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                                Map<String,Object>map){
        try {
            productService.onSale(productId);
        }catch (SellException e){
            log.error(e.getMessage());
            map.put("msg", "上架商品"+e.getMessage());
            map.put("url","/spring/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.PRODUCT_ON_SALE_SUCCESS.getMessage());
        map.put("url","/spring/seller/product/list");
        return new ModelAndView("common/success");
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                      Map<String,Object>map){
        if(!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }

        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);

        return new ModelAndView("product/index",map);
    }
}
