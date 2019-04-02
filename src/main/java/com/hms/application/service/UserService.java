package com.hms.application.service;


import com.hms.application.entity.InfoUser;

import java.util.List;

public interface UserService {
    //用户首次打开小程序时在用户表里创建新用户
    public String createNewUser(String userWechat, String userType, String creationTime);

    //用户完善信息后台数据库根据微信号执行update操作
    public String updateUser(String userName, String userPhone, String userSex, String userWechat);

    //通过用户微信id查询用户信息是否存在，存在则返回查找到的对象
    public List<InfoUser> findUser(String userWechat);
}
