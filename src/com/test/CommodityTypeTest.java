package com.test;

import com.dao.CommodityTypeDao;
import com.vo.CommodityType;

import java.util.List;

public class CommodityTypeTest {
    public static void main(String[] args) {
        CommodityTypeDao commodityTypeDao = new CommodityTypeDao();
        List<CommodityType> list =commodityTypeDao.getAll();
        for (CommodityType commodityType : list) {
            System.out.println(commodityType.toString());
        }

        //System.out.println(commodityTypeDao.addCmt("手表"));

        //System.out.println(commodityTypeDao.delOneCmt(11));
        //System.out.println(commodityTypeDao.delPartCmt(new int[]{12,13,14}));
        //System.out.println(commodityTypeDao.updCmt(new CommodityType(15,"高达")));
    }
}
