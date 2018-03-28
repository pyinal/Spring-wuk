package com.spring.wvk.service.imp;

import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.spring.wvk.dto.OrderDTO;
import com.spring.wvk.service.PayService;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImp implements PayService{
    @Override
    public void create(OrderDTO orderDTO) {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();

    }
}
