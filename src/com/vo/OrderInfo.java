package com.vo;

public class OrderInfo {
    int orderId;
    int adiId;
    int cartId;
    boolean orderState;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAdiId() {
        return adiId;
    }

    public void setAdiId(int adiId) {
        this.adiId = adiId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public boolean isOrderState() {
        return orderState;
    }

    public void setOrderState(boolean orderState) {
        this.orderState = orderState;
    }


    public OrderInfo() {
    }

    public OrderInfo(int orderId, int adiId, int cartId, boolean orderState) {
        this.orderId = orderId;
        this.adiId = adiId;
        this.cartId = cartId;
        this.orderState = orderState;
    }

    public OrderInfo(int adiId, int cartId) {
        this.adiId = adiId;
        this.cartId = cartId;
    }
}
