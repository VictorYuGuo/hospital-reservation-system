package com.hms.application.service;

import com.hms.application.entity.InfoUser;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface UserLYFService {
    public List<Object[]> selectuserinfo(int userId);

    /**
     * 根据预约表的主键查找记录
     * @param userId
     * @return
     */
    public InfoUser findByUserId(int userId);
}
