package com.hms.application.controller;

import com.hms.application.entity.Clinic;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/8 22:19
 **/
@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    ClinicService clinicService;

    @GetMapping("/find")
    public BaseResponse findAll(){
        //根据删除标志查找未删除的诊所信息
        List<Clinic> clinics = clinicService.findByDm("0");
        return new BaseResponse(clinics);
    }
}
