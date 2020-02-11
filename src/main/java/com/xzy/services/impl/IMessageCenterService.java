package com.xzy.services.impl;

import com.xzy.pojo.Orders;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IMessageCenterService {
   public Orders selectOrders(long userId);

}