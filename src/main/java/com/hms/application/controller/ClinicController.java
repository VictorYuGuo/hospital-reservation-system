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
        List<Clinic> clinics = clinicService.findAll();
        return new BaseResponse(clinics);
    }
}
