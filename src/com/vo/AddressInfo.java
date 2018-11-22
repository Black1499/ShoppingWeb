package com.vo;

public class AddressInfo {
    int adiId;
    int userId;
    String adiPlace;
    String adiName;
    String adiPhone;

    public int getAdiId() {
        return adiId;
    }

    public void setAdiId(int adiId) {
        this.adiId = adiId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAdiPlace() {
        return adiPlace;
    }

    public void setAdiPlace(String adiPlace) {
        this.adiPlace = adiPlace;
    }

    public String getAdiName() {
        return adiName;
    }

    public void setAdiName(String adiName) {
        this.adiName = adiName;
    }

    public String getAdiPhone() {
        return adiPhone;
    }

    public void setAdiPhone(String adiPhone) {
        this.adiPhone = adiPhone;
    }

    public AddressInfo() {
    }

    public AddressInfo(int adiId, int userId, String adiPlace, String adiName, String adiPhone) {
        this.adiId = adiId;
        this.userId = userId;
        this.adiPlace = adiPlace;
        this.adiName = adiName;
        this.adiPhone = adiPhone;
    }

    public AddressInfo(int userId, String adiPlace, String adiName, String adiPhone) {
        this.userId = userId;
        this.adiPlace = adiPlace;
        this.adiName = adiName;
        this.adiPhone = adiPhone;
    }


    @Override
    public String toString() {
        return "AddressInfo{" +
                "adiId=" + adiId +
                ", userId=" + userId +
                ", adiPlace='" + adiPlace + '\'' +
                ", adiName='" + adiName + '\'' +
                ", adiPhone='" + adiPhone + '\'' +
                '}';
    }
}
