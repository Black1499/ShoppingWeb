package com.test;

import com.dao.CommodityInfoDao;
import com.vo.CommodityInfo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CommodityInfoTest {
    public static void main(String[] args) {
        CommodityInfoDao commodityInfoDao= new CommodityInfoDao();
        ArrayList<CommodityInfo> list= (ArrayList<CommodityInfo>) commodityInfoDao.getAll();
        for (CommodityInfo commodityInfo : list) {
            System.out.println(commodityInfo.toString());
        }

        System.out.println("=====================================================");
        CommodityInfo commodityInfo=commodityInfoDao.findById(12);
        System.out.println(commodityInfo.toString());


//        ArrayList<CommodityInfo> list1= (ArrayList<CommodityInfo>) commodityInfoDao.findByName("book");
//        for (CommodityInfo commodityInfo : list1) {
//            System.out.println(commodityInfo.toString());
//        }

//        System.out.println(commodityInfoDao.addCdi(new CommodityInfo(1,"img/12.jpg","Mac Book",BigDecimal.valueOf(7899),"asdfafsfdsadfasdfsa",true)));
//        System.out.println(commodityInfoDao.delOneCdi(22));
//        System.out.println(commodityInfoDao.delPartCdi(new int[]{23,24,25}));
//        System.out.println(commodityInfoDao.updCdi(new CommodityInfo(26,1,"img/12.jpg","Mac Book",BigDecimal.valueOf(7899),"’‚ «√Ë ˆ",true)));
    }
}
