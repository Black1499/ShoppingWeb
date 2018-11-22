package com.bo;

import com.dao.CommodityTypeDao;
import com.vo.CommodityType;

public class CommodityTypeBo {
    private CommodityTypeDao commodityTypeDao = new CommodityTypeDao();

    public boolean getAll() {
        return commodityTypeDao.getAll() != null ? true : false;
    }

    public boolean addCmt(String name) {
        return commodityTypeDao.addCmt(name) == 1 ? true : false;
    }

    public boolean delOneCmt(int id) {
        return commodityTypeDao.delOneCmt(id) == 1 ? true : false;
    }


    public boolean delPartCmt(int[] ids) {
        return commodityTypeDao.delPartCmt(ids) == ids.length ? true : false;
    }

    public boolean updCmt(CommodityType commodityType) {
        return commodityTypeDao.updCmt(commodityType) == 1 ? true : false;
    }
}
