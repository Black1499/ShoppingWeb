package com.test;

import com.dao.OrderInfoDao;
import com.vo.ShoppingCartInfo;

import java.util.List;

public class OrderInfoTest {
    public static void main(String[] args) {
        OrderInfoDao orderInfoDao=new OrderInfoDao();
        List<ShoppingCartInfo> list=orderInfoDao.findByUser(1, 0);
        for (ShoppingCartInfo shoppingCartInfo : list) {
            System.out.println(shoppingCartInfo.toString());
        }
    }
}
