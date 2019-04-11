package com.hms.application.service;

import com.hms.application.entity.infoAppoint;

import java.util.List;

public interface AppointService {
    /**
     * 根据预约表的主键查找记录
     * @param appointId
     * @return
     */
    public infoAppoint findByAppiontId(int appointId);
    /**
     * 插入预约信息方法
     * @param infoAppoint
     */
    public void insert(infoAppoint infoAppoint);

    /**
     * 根据用户编码、日期、删除标记查找记录
     * @return
     */
    public List<infoAppoint> findByUserCodeAndDateAndDm(int userCode,String date,String dm);

    /**
     * 根据用户编码和是否删除标记查找记录
     * @param userCode
     * @param dm
     * @return
     */
    public List<infoAppoint> findByUserCodeAndDm(int userCode,String dm);
}
