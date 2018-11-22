package com.bo;

import com.dao.CommodityInfoDao;
import com.vo.CommodityInfo;
import com.vo.CommodityType;

import java.util.List;

public class CommodityInfoBo {
    private CommodityInfoDao commodityInfoDao = new CommodityInfoDao();

    public boolean getAll() {
        return commodityInfoDao.getAll() != null ? true : false;
    }

    public boolean findByName(String name) {
        return commodityInfoDao.findByName(name) != null ? true : false;
    }

    public boolean findByType(int typeId) {
        return commodityInfoDao.findByType(typeId) != null ? true : false;
    }

    public boolean findById(int id) {
        return commodityInfoDao.findById(id) != null ? true : false;
    }

    public boolean addCdi(CommodityInfo commodityInfo) {
        return commodityInfoDao.addCdi(commodityInfo) == 1 ? true : false;
    }

    public boolean delOneCdi(int id) {
        return commodityInfoDao.delOneCdi(id) == 1 ? true : false;
    }


    public boolean delPartCdi(int[] ids) {
        return commodityInfoDao.delPartCdi(ids) == ids.length ? true : false;
    }


    public boolean updCdi(CommodityInfo commodityInfo) {
        return commodityInfoDao.updCdi(commodityInfo) == 1 ? true : false;
    }
}
