package com.xzy.dao;

import com.xzy.pojo.Orders;

public interface IMessageCenterDao {
    Orders selectOrders(long userId);
}
