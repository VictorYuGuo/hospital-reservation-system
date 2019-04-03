package com.hms.application.controller;

import com.hms.application.entity.infoDoc;
import com.hms.application.errors.ErrorEnum;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

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
    @PostMapping("/NPP")
    public BaseResponse selectNPP(@Param(value ="phone")String phone){
        List<infoDoc> NPP = doctorService.getdocNameAndpkDocAnddocPicture(phone);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(NPP);
        return baseResponse;
    }


}
