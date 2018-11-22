package com.dao;

import com.interfaces.OrderInfoDataBaseDao;
import com.util.JDBCUtil;
import com.vo.OrderInfo;
import com.vo.ShoppingCartInfo;

import java.util.List;

public class OrderInfoDao implements OrderInfoDataBaseDao {

    public List<ShoppingCartInfo> findByUser(int userId, int state) {
        String sql = "select s.cartId cartId,s.userId userId,c.cmdPicture cmdPicture,c.cmdDescribe cmdDescribe," +
                "c.cmdPrice cmdPrice,s.cartNumber cartNumber " +
                "from commodityInfo c inner join shoppingCart s on c.cmdId=s.cmdId " +
                "inner join orderInfo o on o.cartId=s.cartId " +
                "where s.userId=? and o.orderState=?";
        return JDBCUtil.queryForList(sql, ShoppingCartInfo.class, userId, state);
    }

    @Override
    public int addOrder(int cartId) {
        return JDBCUtil.excuteUpdate("insert into orderInfo values(0,null,?,0)", cartId);
    }

    @Override
    public int updOrder(int cartId, int adiId) {
        return JDBCUtil.excuteUpdate("update orderinfo set adiId=?,orderState=1 where cartId=?", adiId, cartId);
    }
}
