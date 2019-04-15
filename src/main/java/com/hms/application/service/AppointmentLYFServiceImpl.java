package com.hms.application.service;

import com.hms.application.entity.InfoUser;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoAppoint;
import com.hms.application.repository.AppointmentLYFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.List;

/**
 * @Description ToDo
 * @Author Lyf
 * @Date 2019/4/2 20:49
 **/
@Service
public class AppointmentLYFServiceImpl implements AppointmentLYFService{
    @Autowired
    AppointmentLYFRepository appointmentRepository;

    @Override
    public List<infoAppoint>findByAppointDoc(int AppointDoc){
        List<infoAppoint> appointinfo = appointmentRepository.findByAppointDoc(AppointDoc);
        return appointinfo;
    }

    @Override
    public List<infoAppoint> selectNNP(int appointDoc,String appointDate){
        List<infoAppoint> appointinfo = appointmentRepository.selectNNP(appointDoc,appointDate);
        return appointinfo;
    }

    @Override
    public List<infoAppoint> selectappoint(String userName,String appointDate,int appointDoc){
        List<infoAppoint> appointinfo = appointmentRepository.selectappoint(userName,appointDate,appointDoc);
        return appointinfo;
    }
    @Override
    public List<infoAppoint> selectnameinfo(String userName,int appointDoc){
        List<infoAppoint> appointinfo = appointmentRepository.selectnameinfo(userName,appointDoc);
        return appointinfo;
    }

    @Override
    public String updateEnd(int appointId,String end)
    {
        appointmentRepository.updateEnd(appointId,end);
        return "success";
    }

}
