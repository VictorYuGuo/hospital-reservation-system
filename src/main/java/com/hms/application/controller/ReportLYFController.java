package com.hms.application.controller;
import com.hms.application.entity.infoAppoint;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoReport;
import com.hms.application.errors.ErrorEnum;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.ReportLYFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/report")
public class ReportLYFController {
    @Autowired
    ReportLYFService reportService;

    /**
     * 用户插入report数据信息
     * *
     * @param appointid
     * @param usercode
     * @param username
     * @param pkdoc
     * @param docname
     * @param reportsubject
     * @param reportresult
     * @param reportmoney
     * @param reportdate
     * @param creationtime
     * @param dm
     * @return
     */
    @PostMapping("/insertreport")
    public BaseResponse insertreportinfo(@Param(value = "appointid") int appointid,@Param(value = "usercode") int usercode,@Param(value = "username" )String username,
                                         @Param(value = "pkdoc")int pkdoc,@Param(value = "docname")String docname,@Param(value="reportsubject")String reportsubject,
                                         @Param(value = "reportresult")String reportresult,@Param(value = "reportmoney")String reportmoney,
                                         @Param(value = "reportdate")String reportdate,@Param(value="creationtime")String creationtime,@Param(value="dm")String dm){
       String reportinfo = reportService.insertnewreport(appointid,usercode,username,pkdoc,docname,reportsubject,reportresult,reportmoney,reportdate,creationtime,dm);
        if ("success".equals(reportinfo))
            return new BaseResponse();
        else
            return new BaseResponse(ErrorEnum.INSERT_FAIL);
    }

    /**
     * 用户用usercode和reportDate请求预约信息
     * *
     * @param usercode
     * @param reportdate
     * @return
     */
    @PostMapping("/reportdate")
    public BaseResponse reportdate(@Param(value = "usercode")int usercode,@Param(value = "reportdate")String reportdate)
    {
        List<infoReport> reportinfo = reportService.selectreport(usercode,reportdate);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(reportinfo);
        return baseResponse;
    }

}
