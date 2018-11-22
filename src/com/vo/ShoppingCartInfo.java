package com.vo;

import java.math.BigDecimal;

public class ShoppingCartInfo {
    int cartId;
    int userId;
    String cmdPicture;
    String cmdDescribe;
    BigDecimal cmdPrice;
    int cartNumber;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCmdPicture() {
        return cmdPicture;
    }

    public void setCmdPicture(String cmdPicture) {
        this.cmdPicture = cmdPicture;
    }

    public String getCmdDescribe() {
        return cmdDescribe;
    }

    public void setCmdDescribe(String cmdDescribe) {
        this.cmdDescribe = cmdDescribe;
    }

    public BigDecimal getCmdPrice() {
        return cmdPrice;
    }

    public void setCmdPrice(BigDecimal cmdPrice) {
        this.cmdPrice = cmdPrice;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }


    public ShoppingCartInfo(int cartId, int userId, String cmdPicture, String cmdDescribe, BigDecimal cmdPrice, int cartNumber) {
        this.cartId = cartId;
        this.userId = userId;
        this.cmdPicture = cmdPicture;
        this.cmdDescribe = cmdDescribe;
        this.cmdPrice = cmdPrice;
        this.cartNumber = cartNumber;
    }

    public ShoppingCartInfo() {
    }

    @Override
    public String toString() {
        return "ShoppingCartInfo{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", cmdPicture='" + cmdPicture + '\'' +
                ", cmdDescribe='" + cmdDescribe + '\'' +
                ", cmdPrice=" + cmdPrice +
                ", cartNumber=" + cartNumber +
                '}';
    }
}
