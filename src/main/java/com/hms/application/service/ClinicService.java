package com.hms.application.service;

import com.hms.application.entity.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic>findAll();

    //根据删除标志查找分诊所
    List<Clinic>findByDm(String dm);
}
