package com.bo;

import com.dao.ShoppingCartDao;
import com.vo.ShoppingCart;

import java.util.List;

public class ShoppingCartBo {
    private ShoppingCartDao shoppingCartDao = new ShoppingCartDao();

    public boolean findByUser(int userId,int state) {
        return shoppingCartDao.findByUser(userId,state) != null ? true : false;
    }

    public boolean addCart(ShoppingCart shoppingCart) {
        return shoppingCartDao.addCart(shoppingCart) != 0 ? true : false;
    }

    public boolean delOneCart(int id) {
        return shoppingCartDao.delOneCart(id) != 0 ? true : false;
    }

    public boolean delPartCart(int[] ids) {
        return shoppingCartDao.delPartCart(ids) != 0 ? true : false;
    }

    public boolean updCart(ShoppingCart shoppingCart) {
        return shoppingCartDao.updCart(shoppingCart) != 0 ? true : false;
    }


    public boolean updState(int cartId,boolean proState) {
        return shoppingCartDao.updState(cartId,proState) != 0 ? true : false;
    }
}
