package com.ecomm.dao;

import com.ecomm.model.OrderDetail;

public interface OrderDAO 
{
public boolean paymentProcess(OrderDetail orderDetail);
public boolean updateCartItemsStatus(String username);
}
