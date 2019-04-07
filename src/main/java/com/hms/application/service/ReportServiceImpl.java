package com.hms.application.service;

import com.hms.application.entity.infoReport;
import com.hms.application.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/3 23:39
 **/

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    ReportRepository reportRepository;

    @Override
    public List<infoReport> findByUserCode(int userCode) {
        return reportRepository.findByUserCode(userCode);
    }

    @Override
    public List<infoReport> findByUserCodeAndReportDate(int userCode, String reportDate) {
        return reportRepository.findByUserCodeAndReportDate(userCode,reportDate);
    }

    @Override
    public List<infoReport> findByUserCodeAndReportDateAndDm(int userCode, String reportDate, String dm) {
        return reportRepository.findByUserCodeAndReportDateAndDm(userCode,reportDate,dm);
    }

    @Override
    public List<infoReport> findByUserCodeAndReportDateContainingAndDm(int userCode, String reportDate, String dm) {
        return reportRepository.findByUserCodeAndReportDateContainingAndDm(userCode,reportDate,dm);
    }
}
