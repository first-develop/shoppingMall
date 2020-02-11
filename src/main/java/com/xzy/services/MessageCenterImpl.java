package com.xzy.services;

import com.xzy.dao.IMessageCenterDao;
import com.xzy.pojo.Orders;
import com.xzy.services.impl.IMessageCenterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderUserService")
public class MessageCenterImpl implements IMessageCenterService {
    @Resource
    private IMessageCenterDao orderDao;
    @Override
    public Orders selectOrders(long userId) {
        return orderDao.selectOrders(userId);
    }

}
