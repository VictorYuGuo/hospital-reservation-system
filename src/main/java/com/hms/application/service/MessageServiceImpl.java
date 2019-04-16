package com.hms.application.service;

import com.hms.application.entity.infoMessage;
import com.hms.application.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/16 17:13
 **/
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageRepository messageRepository;
    @Override
    public void insert(infoMessage infoMessage) {
        messageRepository.saveAndFlush(infoMessage);
    }

    @Override
    public List<infoMessage> findByPkUserAndPkDoc(int pkUser, int pkDoc) {
        return messageRepository.findByPkDocAndPkUser(pkDoc,pkUser);
    }
}
