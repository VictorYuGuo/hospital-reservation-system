package com.hms.application.service;

import com.hms.application.entity.infoDoc;
import com.hms.application.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/3 20:12
 **/

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public infoDoc findbyPkDoc(int pkDoc) {
        return doctorRepository.findByPkDoc(pkDoc);
    }

    @Override
    public List<infoDoc> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public List<String> findAllSubject() {
        return doctorRepository.findAllSubject();
    }
}
