package com.hms.application.repository;

import com.hms.application.entity.infoDoc;
import org.springframework.data.jpa.repository.JpaRepository;

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
    //根据医生名查找医生信息，

}
