package com.hms.application.service;

import com.hms.application.entity.infoReport;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportLYFService {
    public String insertnewreport(int appointId,int userCode,String userName,
                                 int pkDoc,String docName,String reportSubject,
                                 String reportResult,String reportMoney,
                                  String reportDate,String creationTime,String dm);

    public List<infoReport> selectreport(int userCode,String reportDate);
}
