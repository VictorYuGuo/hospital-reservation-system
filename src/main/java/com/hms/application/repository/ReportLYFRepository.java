package com.hms.application.repository;

import com.hms.application.entity.infoReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface ReportLYFRepository extends JpaRepository<infoReport,String>{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO info_report(appoint_id,user_code,user_name,pk_doc,doc_name,report_subject,report_result,report_money,report_date,creation_time,dm) values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)", nativeQuery = true)
    void insertreport(int appointId,int userCode,String userName,
                      int pkDoc,String docName,String reportSubject,
                      String reportResult,String reportMoney,
                      String reportDate,String creationTime,String dm);

    @Transactional
    @Modifying
    @Query(value = "Select * From info_report WHERE user_code =:userCode AND report_date LIKE :reportDate",nativeQuery = true)
    List<infoReport> selectreport(@Param(value = "userCode")int userCode,@Param(value = "reportDate") String reportDate);

    @Transactional
    @Modifying
    @Query(value = "Select * From info_report WHERE user_code =:userCode and dm=0 ",nativeQuery = true)
    List<infoReport> selectallreport(@Param(value = "userCode")int userCode);
}
