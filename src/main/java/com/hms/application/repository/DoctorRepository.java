package com.hms.application.repository;

import com.hms.application.entity.infoDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 医生信息数据库接口
 */
public interface DoctorRepository extends JpaRepository<infoDoc,String> {
    //根据主键查找医生信息
    infoDoc findByPkDoc(int pkDoc);
    //根据医生类别查找医生信息
    List<infoDoc>findByDocTypeAndDm(String docType,String dm);
    //根据删除标志查找医生信息
    List<infoDoc>findByDm(String dm);
    //根据医生就诊科目模糊查询医生信息
    List<infoDoc>findByDocSubjectContainingAndDm(String docSubject,String dm);

    //查找所有的科室信息
    @Transactional
    @Modifying
    @Query(value = "select doc_type from info_doc where dm = '0' group by doc_type",nativeQuery = true)
    List<String>findAllSubject();

}
