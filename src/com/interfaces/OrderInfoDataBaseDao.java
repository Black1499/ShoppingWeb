package com.interfaces;

import com.vo.OrderInfo;

public interface OrderInfoDataBaseDao {
    int addOrder(int cartId);

    int updOrder(int cartId,int adiId);
}
