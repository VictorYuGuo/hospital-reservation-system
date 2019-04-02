package com.hms.application.service;

import com.hms.application.entity.InfoUser;
import com.hms.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/2 20:49
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public String createNewUser(String userWechat, String userType, String creationTime) {
        InfoUser newUser = new InfoUser();
        newUser.setUserWechat(userWechat);
        newUser.setUserType(userType);
        newUser.setCreationTime(creationTime);
        InfoUser result = userRepository.save(newUser);
        if(result==null)
            return "fail";
        else
            return "success";
    }

    @Override
    public String updateUser(String userName, String userPhone, String userSex, String userWechat) {
        userRepository.updateNameAndPhoneAndSexByUserWechat(userName,userPhone,userSex,userWechat);
        return "success";
    }

    @Override
    public List<InfoUser> findUser(String userWechat) {
        List<InfoUser> users = userRepository.findByUserWechat(userWechat);
        return users;
    }
}
