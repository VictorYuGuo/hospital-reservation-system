package com.hms.application.service;

import com.hms.application.entity.infoMessage;

import java.util.List;

public interface MessageService {
    public void insert(infoMessage infoMessage);

    public List<infoMessage> findByPkUserAndPkDoc(int pkUser, int pkDoc);
}
