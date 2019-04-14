package com.hms.application.service;

import com.hms.application.entity.InfoUser;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoMessage;
import com.hms.application.repository.UserLYFRepository;
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
public class UserLYFServiceImpl implements UserLYFService{
    @Autowired
    UserLYFRepository userRepository;

    @Override
    public List<Object[]> selectuserinfo(int userId) {
        List<Object[]> userinfo = userRepository.selectuserinfo(userId);
        return userinfo;
    }
    @Override
    public InfoUser findByUserId(int userId) {
        return userRepository.findByUserId(userId);
    }
}
