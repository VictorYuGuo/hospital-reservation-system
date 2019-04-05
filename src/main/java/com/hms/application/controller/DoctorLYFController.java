package com.hms.application.controller;

import com.hms.application.entity.infoAppoint;
import com.hms.application.entity.infoDoc;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.DoctorLYFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorLYFController {
    @Autowired
    DoctorLYFService doctorService;

    /**
     * 用户登录验证，根据结果返回不同值
     *
     * @param phone
     * @param password
     * @return
     */
    @PostMapping("/check")
    public BaseResponse checkDoc(@Param(value ="phone")String phone, @Param(value = "password")String password){
        int checkresult = doctorService.checkDoctor(phone,password);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(checkresult);
        return baseResponse;
    }

    /**
     * 用户用phone请求name、pkdoc、picture
     *
     * @param phone
     * @return
     */
    @PostMapping("/doctorinfo")
    public BaseResponse getdoctorinfo(@Param(value ="phone")String phone){
        List<infoDoc> doctorinfo = doctorService.findByDocPhone(phone);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(doctorinfo);
        return baseResponse;
    }



}
