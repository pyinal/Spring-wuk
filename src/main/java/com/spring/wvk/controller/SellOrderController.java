package com.spring.wvk.controller;

import com.spring.wvk.dto.OrderDTO;
import com.spring.wvk.enums.ResultEnum;
import com.spring.wvk.exception.SellException;
import com.spring.wvk.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "3") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOpage = orderService.findList(pageRequest);
        map.put("orderDTOPage",orderDTOpage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("order/list", map);
    }

    @GetMapping("cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String,Object>map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancle(orderDTO);
        }catch (SellException e){
            log.error(e.getMessage());
            map.put("msg", "卖家端取消订单 "+e.getMessage());
            map.put("url","/spring/seller/order/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url","/spring/seller/order/list");
        return new ModelAndView("common/success");
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String,Object>map){
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        }catch (SellException e){
            log.error(e.getMessage());
            map.put("msg", "卖家端查询订单 "+e.getMessage());
            map.put("url","/spring/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e){
            log.error(e.getMessage());
            map.put("msg", "卖家端完结订单 "+e.getMessage());
            map.put("url","/spring/seller/order/list");
            return new ModelAndView("common/error",map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/spring/seller/order/list");
        return new ModelAndView("common/success");
    }
}
