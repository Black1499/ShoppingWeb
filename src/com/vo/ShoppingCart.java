package com.vo;

import java.math.BigDecimal;

public class ShoppingCart {
    int cartId;
    int cmdId;
    int userId;
    int cartNumber;
    BigDecimal cartPrice;
    boolean cartState;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCmdId() {
        return cmdId;
    }

    public void setCmdId(int cmdId) {
        this.cmdId = cmdId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    public BigDecimal getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(BigDecimal cartPrice) {
        this.cartPrice = cartPrice;
    }

    public void setCartState(boolean cartState) {
        this.cartState = cartState;
    }
    public boolean getCartState() {
        return this.cartState;
    }

    public ShoppingCart() {
    }


    public ShoppingCart(int cartId, int cmdId, int userId, int cartNumber, BigDecimal cartPrice, boolean cartState) {
        this.cartId = cartId;
        this.cmdId = cmdId;
        this.userId = userId;
        this.cartNumber = cartNumber;
        this.cartPrice = cartPrice;
        this.cartState = cartState;
    }


    public ShoppingCart(int cmdId, int userId, BigDecimal cartPrice) {
        this.cmdId = cmdId;
        this.userId = userId;
        this.cartPrice = cartPrice;
    }

    public ShoppingCart(int cartId, int cartNumber, BigDecimal cartPrice, boolean cartState) {
        this.cartId = cartId;
        this.cartNumber = cartNumber;
        this.cartPrice = cartPrice;
        this.cartState = cartState;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId=" + cartId +
                ", cmdId=" + cmdId +
                ", userId=" + userId +
                ", cartNumber=" + cartNumber +
                ", cartPrice=" + cartPrice +
                ", cartState=" + cartState +
                '}';
    }
}
