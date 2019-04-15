package com.hms.application.controller;

import com.hms.application.bean.ReportHistory;
import com.hms.application.bean.ReportResult;
import com.hms.application.entity.infoAppoint;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoReport;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.AppointService;
import com.hms.application.service.DoctorService;
import com.hms.application.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/3 23:53
 **/

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    AppointService appointService;

    @GetMapping("/find/type=usercode")
    public BaseResponse findByUserCode(@Param(value = "code")int code){
        List<infoReport> reports = reportService.findByUserCode(code);
        return new BaseResponse(reports);
    }

    @GetMapping("/find/type=usercode&dm")
    public BaseResponse findByUserCodeAndDm(@Param(value = "code")int code,@Param(value = "Dm")String dm){
        List<infoReport> reports = reportService.findByUserCodeAndDm(code,dm);
        ArrayList<ReportHistory> histories  = new ArrayList();
        for(int i=0;i<reports.size();i++){
            infoReport report = reports.get(i);
            infoAppoint appoint = appointService.findByAppiontId(report.getAppointId());
            infoDoc doctor = doctorService.findbyPkDoc(report.getpkDoc());
            ReportHistory reportHistory = new ReportHistory();
            reportHistory.setBillId(report.getBillId());
            reportHistory.setDocUrl(doctor.getDocUrl());
            reportHistory.setDocName(doctor.getDocName());
            reportHistory.setClinic(appoint.getAppointClinic());
            reportHistory.setReportDate(report.getReportDate());
            reportHistory.setSubject(report.getReportSubject());
            reportHistory.setResult(report.getReportResult());
            histories.add(reportHistory);
        }
        return new BaseResponse(histories);
    }

    @GetMapping("/find/type=usercode&reportdate")
    public BaseResponse findUserCodeAndReportDate(@Param(value = "code")int code,@Param(value = "date")String date){
        List<infoReport>reports = reportService.findByUserCodeAndReportDate(code,date);
        return new BaseResponse(reports);
    }

    @GetMapping("/find/type=usercode&reportdate&dm")
    public BaseResponse findByUserCodeAndReportDateAndDm(@Param(value = "code")int code,@Param(value = "date")String date,@Param(value = "dm")String dm){
        List<infoReport>reports = reportService.findByUserCodeAndReportDateContainingAndDm(code,date,dm);
        if(reports.size()==0){
            return new BaseResponse();
        }
        infoReport report = new infoReport();
        report = reports.get(0);
        //根据报告中的医生pk获取医生的姓名和照片url
        infoDoc doctor = doctorService.findbyPkDoc(report.getpkDoc());
        ReportResult reportResult = new ReportResult();
        reportResult.setSubject(report.getReportSubject());//获取科室
        reportResult.setReportResult(report.getReportResult());//获取检查报告结果
        reportResult.setDocName(doctor.getDocName());//获取医生姓名
        reportResult.setDocUrl(doctor.getDocUrl());//获取医生照片
        return new BaseResponse(reportResult);
    }

}
