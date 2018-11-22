package com.dao;

import com.interfaces.CommodityInfoDataBaseDao;
import com.util.JDBCUtil;
import com.vo.CommodityInfo;

import java.util.List;

public class CommodityInfoDao implements CommodityInfoDataBaseDao {
    @Override
    public List<CommodityInfo> getAll() {
        return JDBCUtil.queryForList("select * from commodityinfo", CommodityInfo.class, null);
    }

    @Override
    public List<CommodityInfo> findByName(String name) {
        return JDBCUtil.queryForList("select * from commodityinfo where cmdName like '%"+name+"%' ", CommodityInfo.class,null);
    }

    @Override
    public List<CommodityInfo> findByType(int typeId) {
        return JDBCUtil.queryForList("select * from commodityinfo where typeId=? ", CommodityInfo.class,typeId);
    }

    @Override
    public int addCdi(CommodityInfo commodityInfo) {
        int state=0;
        if(commodityInfo.getCmdState()){
            state=1;
        }
        return JDBCUtil.excuteUpdate("insert into commodityinfo values(0,?,?,?,?,?,?)", commodityInfo.getTypeId(), commodityInfo.getCmdPicture(),
                commodityInfo.getCmdName(), commodityInfo.getCmdPrice(), commodityInfo.getCmdDescribe(), state);
    }

    @Override
    public int delOneCdi(int id) {
        return JDBCUtil.excuteUpdate("delete from commodityinfo where cmdId=?", id);
    }

    @Override
    public int delPartCdi(int[] ids) {
        String sql = "delete from commodityinfo where cmdId in (";
        String link = "";
        for (int i = 0; i < ids.length; i++) {
            sql += link + "?";
            link = ",";
        }
        sql += ")";
        int num = JDBCUtil.excuteUpdates(sql, ids);
        return num;
    }

    @Override
    public CommodityInfo findById(int cmdId) {
        return JDBCUtil.queryForObject("select * from commodityinfo where cmdId=?",CommodityInfo.class,cmdId);
    }

    @Override
    public int updCdi(CommodityInfo commodityInfo) {
        int state=0;
        if(commodityInfo.getCmdState()){
            state=1;
        }
        return JDBCUtil.excuteUpdate("update commodityinfo set typeId=?,cmdPicture=?,cmdName=?,cmdPrice=?,cmdDescribe=?,cmdState=? where cmdId=?",
                commodityInfo.getTypeId(), commodityInfo.getCmdPicture(), commodityInfo.getCmdName(),
                commodityInfo.getCmdPrice(), commodityInfo.getCmdDescribe(), state, commodityInfo.getCmdId());
    }
}
