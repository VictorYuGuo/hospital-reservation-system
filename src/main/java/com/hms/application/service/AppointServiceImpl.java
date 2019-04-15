package com.hms.application.service;

import com.hms.application.entity.infoAppoint;
import com.hms.application.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/7 17:24
 **/
@Service
public class AppointServiceImpl implements AppointService{
    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public infoAppoint findByAppiontId(int appointId) {
        return appointmentRepository.findByAppointId(appointId);
    }

    @Override
    public void insert(infoAppoint infoAppoint) {
        appointmentRepository.saveAndFlush(infoAppoint);
    }

    @Override
    public List<infoAppoint> findByUserCodeAndDateAndDm(int userCode, String date, String dm) {
        return appointmentRepository.findByUserCodeAndAppointDateContainingAndDm(userCode,date,dm);
    }

    @Override
    public List<infoAppoint> findByUserCodeAndDateAndDmAndEnd(int userCode, String date, String dm, String end) {
        return appointmentRepository.findByUserCodeAndAppointDateContainingAndDmAndEnd(userCode,date,dm,end);
    }

    @Override
    public List<infoAppoint> findByUserCodeAndDm(int userCode, String dm) {
        return appointmentRepository.findByUserCodeAndDm(userCode,dm);
    }

    @Override
    public void deleteAppoint(String appointDate, int userCode) {
        appointmentRepository.deleteAppoint(appointDate,userCode);
    }
}
