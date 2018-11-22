package com.dao;

import com.interfaces.CommodityTypeDataBaseDao;
import com.util.JDBCUtil;
import com.vo.CommodityType;

import java.util.List;

public class CommodityTypeDao implements CommodityTypeDataBaseDao {
    @Override
    public List<CommodityType> getAll() {
        return JDBCUtil.queryForList("select * from commoditytype",CommodityType.class,null);
    }

    @Override
    public int addCmt(String name) {
        return JDBCUtil.excuteUpdate("insert into commoditytype(typeName) values(?)",name);
    }

    @Override
    public int delOneCmt(int id) {
        return JDBCUtil.excuteUpdate("delete from commoditytype where typeId=?",id);
    }

    @Override
    public int delPartCmt(int[] id) {
        String sql="delete from commoditytype where typeId in (";
        String link="";
        for (int i = 0; i <id.length ; i++) {
            sql+=link+"?";
            link=",";
        }
        sql+=")";
        int num=JDBCUtil.excuteUpdates(sql,id);
        return num;
    }

    @Override
    public int updCmt(CommodityType commodityType) {
        return JDBCUtil.excuteUpdate("update commoditytype set typeName=? where typeId=?",commodityType.getTypeName(),commodityType.getTypeId());
    }
}
