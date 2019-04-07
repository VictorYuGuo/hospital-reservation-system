package com.hms.application.controller;

import com.hms.application.bean.ReportResult;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoReport;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.DoctorService;
import com.hms.application.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/find/type=usercode")
    public BaseResponse findByUserCode(@Param(value = "code")int code){
        List<infoReport> reports = reportService.findByUserCode(code);
        return new BaseResponse(reports);
    }

    @GetMapping("/find/type=usercode&reportdate")
    public BaseResponse findUserCodeAndReportDate(@Param(value = "code")int code,@Param(value = "date")String date){
        List<infoReport>reports = reportService.findByUserCodeAndReportDate(code,date);
        return new BaseResponse(reports);
    }

    @GetMapping("/find/type=usercode&reportdate&dm")
    public BaseResponse findByUserCodeAndReportDateAndDm(@Param(value = "code")int code,@Param(value = "date")String date,@Param(value = "dm")String dm){
        List<infoReport>reports = reportService.findByUserCodeAndReportDateContainingAndDm(code,date,dm);
        infoReport report = new infoReport();
        report = reports.get(0);
        //根据报告中的医生pk获取医生的姓名和照片url
        List<infoDoc> doctors = doctorService.findbyPkDoc(report.getPkDoc());
        ReportResult reportResult = new ReportResult();
        reportResult.setSubject(report.getReportSubject());//获取科室
        reportResult.setReportResult(report.getReportResult());//获取检查报告结果
        reportResult.setDocName(doctors.get(0).getDocName());//获取医生姓名
        reportResult.setDocUrl(doctors.get(0).getDocUrl());//获取医生照片
        return new BaseResponse(reports);
    }

}
