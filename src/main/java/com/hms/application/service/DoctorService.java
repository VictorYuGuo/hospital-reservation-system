package com.hms.application.service;

import com.hms.application.entity.infoDoc;

import java.util.List;

public interface DoctorService {
    /**
     * 根据医生主键查找医生详细信息
     */
    public infoDoc findbyPkDoc(int pkDoc);

    /**
     * 查找所有医生的信息
     */
    public List<infoDoc>findAll();

    /**
     * 根据删除标志查找医生信息
     */
    public List<infoDoc>findByDm(String dm);

    /**
     * 查找所有科室
     */
    public List<String>findAllSubject();
}
