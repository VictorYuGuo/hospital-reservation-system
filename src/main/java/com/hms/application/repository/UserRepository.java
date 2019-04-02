package com.hms.application.repository;

import com.hms.application.entity.InfoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户信息表数据库操作接口
 */
public interface UserRepository extends JpaRepository<InfoUser, String> {
    //根据微信openid查找用户
    List<InfoUser> findByUserWechat(String userWechat);

    //根据用户编码查找用户
    List<InfoUser> findByUserId(String userID);

    //原生sql插入新记录
    @Transactional
    @Modifying
    @Query(value = "Insert into info_user(user_wechat,user_type,creation_time) values(?1,?2,?3)", nativeQuery = true)
    void addUser(String userWechat, String userType, String creationTime);

    //非原生sql根据微信openid更新信息
    @Transactional
    @Modifying
    @Query(value = "Update InfoUser set userName = :userName , userPhone = :userPhone, userSex = :userSex where userWechat = :userWechat")
    void updateNameAndPhoneAndSexByUserWechat(@Param(value = "userName") String userName, @Param(value = "userPhone") String userPhone, @Param(value = "userSex") String userSex, @Param(value = "userWechat") String userWechat);

}
