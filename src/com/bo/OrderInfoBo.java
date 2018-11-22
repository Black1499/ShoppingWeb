package com.bo;

import com.dao.OrderInfoDao;
import com.vo.OrderInfo;

public class OrderInfoBo {
    private OrderInfoDao orderInfoDao = new OrderInfoDao();
    public boolean findByUser(int userId,int state) {
        return orderInfoDao.findByUser(userId,state) != null ? true : false;
    }
    public boolean addOrder(int cartId) {
        return orderInfoDao.addOrder(cartId) == 1 ? true : false;
    }

    public boolean updOrder(int cartId, int adiId) {
        return orderInfoDao.updOrder(cartId, adiId) == 1 ? true : false;
    }
}
