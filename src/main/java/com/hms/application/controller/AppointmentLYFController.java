package com.hms.application.controller;
import com.hms.application.entity.infoAppoint;
import com.hms.application.entity.infoDoc;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.AppointmentLYFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appoint")
public class AppointmentLYFController {
    @Autowired
    AppointmentLYFService appointmentService;

    /**
     * 用户用appointdoc请求预约信息
     * *
     * @param appointdoc
     * @return
     */
    @PostMapping("/appointinfo")
    public BaseResponse getappointinfo(@Param(value ="appointdoc")int appointdoc){
        List<infoAppoint> appointinfo = appointmentService.findByAppointDoc(appointdoc);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(appointinfo);
        return baseResponse;
    }

    /**
     * 用户用appointdoc和appointDate请求预约信息
     * *
     * @param appointdoc
     * @param appointdate
     * @return
     */
    @PostMapping("/appointdateinfo")
    public BaseResponse getappointdateinfo(@Param(value ="appointdoc")int appointdoc,@Param(value = "appointdate")String appointdate){
        List<infoAppoint> appointinfo = appointmentService.selectNNP(appointdoc,appointdate);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(appointinfo);
        return baseResponse;
    }

    /**
     * 用户用userName和appointDate请求预约信息
     * *
     * @param username
     * @param appointdate
     * @param appointdoc
     * @return
     */
    @PostMapping("/appointuserinfo")
    public BaseResponse getappointdateinfo(@Param(value ="username")String username,@Param(value = "appointdate")String appointdate,@Param(value = "appointdoc")int appointdoc){
        List<infoAppoint> appointinfo = appointmentService.selectappoint(username,appointdate,appointdoc);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(appointinfo);
        return baseResponse;
    }

    /**
     * 用户用userName和appointDate请求预约信息
     * *
     * @param username
     * @param appointdoc
     * @return
     */
    @PostMapping("/appointnameinfo")
    public BaseResponse getnamedateinfo(@Param(value ="username")String username,@Param(value = "appointdoc")int appointdoc){
        List<infoAppoint> appointinfo = appointmentService.selectnameinfo(username,appointdoc);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(appointinfo);
        return baseResponse;
    }

    /**
     * end更改
     * *
     * @param end
     * @param appointid
     * @return
     */
    @PostMapping("/updateend")
    public BaseResponse upenddate(@Param(value = "appointid")int appointid,@Param(value ="end")String end){
        String result = appointmentService.updateEnd(appointid,end);
        return new BaseResponse();
    }

}
