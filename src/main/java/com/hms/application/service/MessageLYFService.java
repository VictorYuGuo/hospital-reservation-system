package com.hms.application.service;

import com.hms.application.entity.infoMessage;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MessageLYFService {
    public List<infoMessage> selectuser(int pkDoc);

    public List<infoMessage> selectmes(int pkDoc,int pkUser);

    public String changestatus(int pkDoc,int pkUser);
}
