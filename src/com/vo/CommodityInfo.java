package com.vo;

import java.math.BigDecimal;

public class CommodityInfo {
    int cmdId;
    int  typeId;
    String cmdPicture;
    String cmdName;
    BigDecimal cmdPrice;
    String cmdDescribe;
    boolean cmdState;

    public int getCmdId() {
        return cmdId;
    }

    public void setCmdId(int cmdId) {
        this.cmdId = cmdId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getCmdPicture() {
        return cmdPicture;
    }

    public void setCmdPicture(String cmdPicture) {
        this.cmdPicture = cmdPicture;
    }

    public String getCmdName() {
        return cmdName;
    }

    public void setCmdName(String cmdName) {
        this.cmdName = cmdName;
    }

    public BigDecimal getCmdPrice() {
        return cmdPrice;
    }

    public void setCmdPrice(BigDecimal cmdPrice) {
        this.cmdPrice = cmdPrice;
    }

    public String getCmdDescribe() {
        return cmdDescribe;
    }

    public void setCmdDescribe(String cmdDescribe) {
        this.cmdDescribe = cmdDescribe;
    }

    public boolean getCmdState() {
        return cmdState;
    }

    public void setCmdState(boolean cmdState) {
        this.cmdState = cmdState;
    }

    public CommodityInfo() {
    }

    public CommodityInfo(int cmdId, int typeId, String cmdPicture, String cmdName, BigDecimal cmdPrice, String cmdDescribe, boolean cmdState) {
        this.cmdId = cmdId;
        this.typeId = typeId;
        this.cmdPicture = cmdPicture;
        this.cmdName = cmdName;
        this.cmdPrice = cmdPrice;
        this.cmdDescribe = cmdDescribe;
        this.cmdState = cmdState;
    }

    public CommodityInfo(int typeId, String cmdPicture, String cmdName, BigDecimal cmdPrice, String cmdDescribe, boolean cmdState) {
        this.typeId = typeId;
        this.cmdPicture = cmdPicture;
        this.cmdName = cmdName;
        this.cmdPrice = cmdPrice;
        this.cmdDescribe = cmdDescribe;
        this.cmdState = cmdState;
    }

    @Override
    public String toString() {
        return "CommodityInfo{" +
                "cmdId=" + cmdId +
                ", typeId=" + typeId +
                ", cmdPicture='" + cmdPicture + '\'' +
                ", cmdName='" + cmdName + '\'' +
                ", cmdPrice=" + cmdPrice +
                ", cmdDescribe='" + cmdDescribe + '\'' +
                ", cmdState=" + cmdState +
                '}';
    }
}
