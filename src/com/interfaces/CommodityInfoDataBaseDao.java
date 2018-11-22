package com.interfaces;

import com.vo.CommodityInfo;

import java.util.List;

public interface CommodityInfoDataBaseDao {
    List<CommodityInfo> getAll();

    List<CommodityInfo> findByName(String name);

    List<CommodityInfo> findByType(int typeId);

    CommodityInfo findById(int cmdId);

    int addCdi(CommodityInfo commodityInfo);

    int delOneCdi(int id);

    int delPartCdi(int[] ids);

    int updCdi(CommodityInfo commodityInfo);
}
