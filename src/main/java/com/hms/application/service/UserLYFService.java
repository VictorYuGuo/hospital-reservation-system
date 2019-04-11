package com.hms.application.service;

import com.hms.application.entity.InfoUser;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface UserLYFService {
    public List<Object[]> selectuserinfo(int userId);
}
