package com.hms.application.repository;

import com.hms.application.entity.infoReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 就诊报告数据库接口
 */
public interface ReportRepository extends JpaRepository<infoReport,String> {
    //根据用户编码查找就诊报告
    List<infoReport>findByUserCode(int userCode);
    //根据用户编码和删除标志查找就诊报告
    List<infoReport>findByUserCodeAndDm(int userCode,String dm);
    //根据就诊日期查找就诊报告
    List<infoReport>findByReportDate(String reportDate);
    //根据用户编码和就诊日期查找就诊报告
    List<infoReport>findByUserCodeAndReportDate(int userCode,String reportDate);
    //根据就诊日期查找未删除的就诊报告
    List<infoReport>findByUserCodeAndReportDateAndDm(int userCode,String reportDate,String dm);
    //根据就诊日期模糊查找未删除的就诊报告
    List<infoReport>findByUserCodeAndReportDateContainingAndDm(int userCode,String reportDate,String dm);

}
