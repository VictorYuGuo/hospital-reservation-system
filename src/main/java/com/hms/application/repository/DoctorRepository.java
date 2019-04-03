package com.hms.application.repository;

import com.hms.application.entity.infoDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * 医生信息数据库接口
 */
public interface DoctorRepository extends JpaRepository<infoDoc,String> {
    //根据主键查找医生信息
    List<infoDoc>findByPkDoc(String pkDoc);
    //根据医生类别查找医生信息
    List<infoDoc>findByDocTypeAndDm(String docType,String dm);
    //根据医生就诊科目模糊查询医生信息
    List<infoDoc>findByDocSubjectContainingAndDm(String docSubject,String dm);
    List<infoDoc>findByDocPhone(String DocPhone);
    List<infoDoc>findByDocPassword(String DocPassword);
    List<infoDoc>findByDocPhoneAndDocPassword(String DocPhone,String DocPassword);

    //非原生sql根据微信openid更新信息
    @Transactional
    @Modifying
    @Query(value = "Select docName,pkDoc,docPicture From infoDoc where docPhone =:docPhone ")
    void selectNNP(@Param(value = "docPhone") String docPhonet);
}
