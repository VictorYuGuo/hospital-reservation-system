package com.hms.application.service;

import com.hms.application.entity.infoReport;

import java.util.List;

public interface ReportService {
    /**
     * 根据用户编码查找当前用户所有就诊报告
     * @return
     */
    public List<infoReport>findByUserCode(int userCode);

    /**
     * 根据用户编码和就诊日期查找就诊报告
     */
    public List<infoReport>findByUserCodeAndReportDate(int userCode,String reportDate);

    /**
     * 根据用户编码和就诊日期和是否删除标记查找就诊报告（通常用于查找未被删除的就诊报告）
     */
    public List<infoReport>findByUserCodeAndReportDateAndDm(int userCode,String reportDate,String dm);

    /**
     *
     */
    public List<infoReport>findByUserCodeAndReportDateContainingAndDm(int userCode,String reportDate,String dm);
}
