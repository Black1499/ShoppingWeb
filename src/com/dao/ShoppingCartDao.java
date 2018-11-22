package com.dao;

import com.interfaces.ShoppingCartDataBaseDao;
import com.util.JDBCUtil;
import com.vo.ShoppingCart;
import com.vo.ShoppingCartInfo;

import java.util.List;

public class ShoppingCartDao implements ShoppingCartDataBaseDao {
    @Override
    public List<ShoppingCartInfo> findByUser(int userId,int state) {
        String sql = "select s.cartId cartId,s.userId userId,c.cmdPicture cmdPicture,c.cmdDescribe cmdDescribe," +
                "c.cmdPrice cmdPrice,s.cartNumber cartNumber " +
                "from commodityInfo c inner join shoppingCart s on c.cmdId=s.cmdId " +
                "where s.userId=? and s.cartState=?";
        return JDBCUtil.queryForList(sql, ShoppingCartInfo.class, userId,state);
    }



    @Override
    public Long count(int userId) {
        String sql = "select count(*) num from shoppingCart where userId=? and cartState=0";
        return (Long) JDBCUtil.queryForMap(sql, userId).get("num");
    }

    @Override
    public int addCart(ShoppingCart shoppingCart) {
        return JDBCUtil.excuteUpdate("insert into shoppingcart values(0,?,?,1,?,0)",
                shoppingCart.getCmdId(), shoppingCart.getUserId(), shoppingCart.getCartPrice());
    }

    @Override
    public int delOneCart(int id) {
        return JDBCUtil.excuteUpdate("delete from shoppingCart where cartId=?", id);
    }

    @Override
    public int delPartCart(int[] ids) {
        String sql = "delete from shoppingCart where cartId in (";
        String link = "";
        for (int i = 0; i < ids.length; i++) {
            sql += link + "?";
            link = ",";
        }
        sql += ")";
        int num = JDBCUtil.excuteUpdates(sql, ids);
        return num;
    }

    @Override
    public int updCart(ShoppingCart shoppingCart) {
        int state = 0;
        if (shoppingCart.getCartState()) {
            state = 1;
        }
        return JDBCUtil.excuteUpdate("update shoppingcart set cartNumber=?,cartPrice=?,cartState=? where cartId=?",
                shoppingCart.getCartNumber(), shoppingCart.getCartPrice(), state, shoppingCart.getCartId());
    }

    @Override
    public int updState(int cartId, boolean states) {
        int state = 0;
        if (states = true) {
            state = 1;
        }
        return JDBCUtil.excuteUpdate("update shoppingcart set cartState=? where cartId=?", state ,cartId);
    }
}
