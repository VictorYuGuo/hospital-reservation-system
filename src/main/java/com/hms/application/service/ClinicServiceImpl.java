package com.hms.application.service;

import com.hms.application.entity.Clinic;
import com.hms.application.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/8 22:04
 **/
@Service
public class ClinicServiceImpl implements ClinicService{
    @Autowired
    ClinicRepository clinicRepository;
    @Override
    public List<Clinic> findAll() {
        return clinicRepository.findAll();
    }

    @Override
    public List<Clinic> findByDm(String dm) {
        return clinicRepository.findByDm(dm);
    }
}
