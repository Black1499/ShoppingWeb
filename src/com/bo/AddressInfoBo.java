package com.bo;

import com.dao.AddressInfoDao;
import com.vo.AddressInfo;

public class AddressInfoBo {
    private AddressInfoDao addressInfoDao = new AddressInfoDao();

    public boolean findByUser(int userId) {
        return addressInfoDao.findByUser(userId) != null ? true : false;
    }

    public boolean addAri(AddressInfo addressInfo) {
        return addressInfoDao.addAri(addressInfo) != 0 ? true : false;
    }

    public boolean delAri(int id) {
        return addressInfoDao.delAri(id) != 0 ? true : false;
    }

    public boolean updAri(AddressInfo addressInfo) {
        return addressInfoDao.updAri(addressInfo) != 0 ? true : false;
    }
}
