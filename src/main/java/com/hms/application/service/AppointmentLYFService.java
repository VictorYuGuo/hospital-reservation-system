package com.hms.application.service;

import com.hms.application.entity.infoAppoint;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentLYFService {
    public List<infoAppoint> findByAppointDoc(int AppointDoc);

    public List<infoAppoint> selectNNP(int appointDoc,String appointDate);

    public List<infoAppoint> selectappoint(String userName,String appointDate,int appointDoc);

    public List<infoAppoint> selectnameinfo(String userName,int appointDoc);

    public String updateEnd(int appointId,String end);
}
