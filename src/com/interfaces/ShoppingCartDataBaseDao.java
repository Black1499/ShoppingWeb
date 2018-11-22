package com.interfaces;

import com.vo.ShoppingCart;
import com.vo.ShoppingCartInfo;

import java.util.List;

public interface ShoppingCartDataBaseDao {
    List<ShoppingCartInfo> findByUser(int userId,int state);

    Long count(int userId);

    int addCart(ShoppingCart shoppingCart);

    int delOneCart(int id);

    int delPartCart(int[] ids);

    int updCart(ShoppingCart shoppingCart);


    int updState(int cartId,boolean state);
}
