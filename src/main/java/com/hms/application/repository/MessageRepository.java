package com.hms.application.repository;

import com.hms.application.entity.infoMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<infoMessage,String>{
    //根据对话双方编码查找对话记录
    List<infoMessage>findByPkDocAndPkUser(int pkDoc,int pkUser);
}
