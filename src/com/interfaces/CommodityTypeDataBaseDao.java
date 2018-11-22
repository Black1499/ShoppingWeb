package com.interfaces;

import com.vo.CommodityType;

import java.util.List;

public interface CommodityTypeDataBaseDao {
    List<CommodityType> getAll();

    int addCmt(String name);

    int delOneCmt(int id);

    int delPartCmt(int[] id);

    int updCmt(CommodityType commodityType);
}
