package com.hms.application.service;

import com.hms.application.entity.InfoUser;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoMessage;
import com.hms.application.repository.MessageLYFRepository;
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
public class MessageLYFServiceImpl implements MessageLYFService{
    @Autowired
    MessageLYFRepository messageRepository;

    @Override
    public List<infoMessage> selectuser(int pkDoc) {
        List<infoMessage> messageinfo = messageRepository.selectuser(pkDoc);
        return messageinfo;
    }


}
