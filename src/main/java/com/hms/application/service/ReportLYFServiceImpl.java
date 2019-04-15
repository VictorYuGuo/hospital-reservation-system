package com.hms.application.service;

import com.hms.application.entity.infoReport;
import com.hms.application.repository.ReportLYFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.List;

/**
 * @Description ToDo
 * @Author Lyf
 * @Date 2019/4/2 20:49
 **/
@Service
public class ReportLYFServiceImpl implements ReportLYFService{
    @Autowired
    ReportLYFRepository reportRepository;

    @Override
    public String insertnewreport(int appointId,int userCode,String userName,
                                             int pkDoc,String docName,String reportSubject,
                                             String reportResult,String reportMoney,
                                             String reportDate,String creationTime,String dm)
    {
        infoReport newreport = new infoReport();
        newreport.setAppointId(appointId);
        newreport.setUserCode(userCode);
        newreport.setUserName(userName);
        newreport.setpkDoc(pkDoc);
        newreport.setDocName(docName);
        newreport.setReportSubject(reportSubject);
        newreport.setReportResult(reportResult);
        newreport.setReportMoney(reportMoney);
        newreport.setReportDate(reportDate);
        newreport.setCreationTime(creationTime);
        newreport.setDm(dm);
        infoReport result = reportRepository.save(newreport);
        if(result==null)
            return "fail";
        else
            return "success";
    //    List<infoReport> reportinfo = reportRepository.insertreport(appointId,userCode,userName,pkDoc,docName,reportSubject,
    //        reportResult,reportMoney, reportDate,creationTime,dm);
    //    return reportinfo;
    }

    @Override
    public List<infoReport> selectreport(int userCode,String reportDate,String docName)
    {
        List<infoReport> reportinfo = reportRepository.selectreport(userCode,reportDate,docName);
        return reportinfo;
    }
    @Override
    public List<infoReport> selectallreport(int userCode)
    {
        List<infoReport> reportinfo = reportRepository.selectallreport(userCode);
        return reportinfo;
    }
}
