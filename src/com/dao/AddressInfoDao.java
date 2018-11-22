package com.dao;

import com.interfaces.AddressInfoDataBaseDao;
import com.util.JDBCUtil;
import com.vo.AddressInfo;

import java.util.List;

public class AddressInfoDao implements AddressInfoDataBaseDao {
    @Override
    public List<AddressInfo> findByUser(int userId) {
        return JDBCUtil.queryForList("select * from addressInfo where userId=?", AddressInfo.class,userId);
    }

    @Override
    public int addAri(AddressInfo addressInfo) {
        return JDBCUtil.excuteUpdate("insert into addressInfo values(0,?,?,?,?)",
                addressInfo.getUserId(),addressInfo.getAdiPlace(),addressInfo.getAdiName(),addressInfo.getAdiPhone());
    }

    @Override
    public int delAri(int id) {
        return JDBCUtil.excuteUpdate("delete from addressInfo where adiId=?",id);
    }

    @Override
    public int updAri(AddressInfo addressInfo) {
        return JDBCUtil.excuteUpdate("update addressInfo set adiPlace=?,adiName=?,adiPhone=? where adiId=? and userId=?",
                addressInfo.getAdiPlace(),addressInfo.getAdiName(),addressInfo.getAdiPhone(),addressInfo.getAdiId(),addressInfo.getUserId());
    }
}
