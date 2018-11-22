package com.test;

import com.dao.ShoppingCartDao;
import com.vo.ShoppingCart;
import com.vo.ShoppingCartInfo;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.List;

public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCartDao shoppingCartDao=new ShoppingCartDao();
        List<ShoppingCartInfo> list=shoppingCartDao.findByUser(1,0);
//        for (ShoppingCartInfo shoppingCart : list) {
//            System.out.println(shoppingCart.toString());
//        }
        System.out.println(shoppingCartDao.count(1));
       // System.out.println(shoppingCartDao.addCart(new ShoppingCart(12,1,BigDecimal.valueOf(3999))));
//
//        System.out.println(shoppingCartDao.delPartCart(new int[]{6,7,8}));
//        System.out.println(shoppingCartDao.delOneCart(5));

        //System.out.println(shoppingCartDao.updCart(new ShoppingCart(10,1, BigDecimal.valueOf(3499),true)));

    }
}
