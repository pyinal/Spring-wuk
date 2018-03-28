package com.spring.wvk.service;

import com.spring.wvk.dto.OrderDTO;

public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
