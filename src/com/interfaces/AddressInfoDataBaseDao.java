package com.interfaces;

import com.vo.AddressInfo;

import java.util.List;

public interface AddressInfoDataBaseDao {
    List<AddressInfo> findByUser(int userId);

    int addAri(AddressInfo addressInfo);

    int delAri(int id);

    int updAri(AddressInfo addressInfo);
}
