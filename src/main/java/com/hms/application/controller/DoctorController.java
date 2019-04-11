package com.hms.application.controller;

import com.hms.application.entity.infoDoc;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/3 21:10
 **/

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/find")
    public BaseResponse getDoctor(@Param(value = "pkDoc")int pkDoc){
        infoDoc doctor = doctorService.findbyPkDoc(pkDoc);
        return new BaseResponse(doctor);
    }

    @GetMapping("/findall")
    public BaseResponse getAllDoctors(){
        List<infoDoc>doctors = doctorService.findAll();
        return new BaseResponse(doctors);
    }
}
