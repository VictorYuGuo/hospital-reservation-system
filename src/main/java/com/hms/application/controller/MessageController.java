package com.hms.application.controller;

import com.hms.application.entity.infoMessage;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/16 22:17
 **/

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/find/type=pkuser&pkdoc")
    public BaseResponse findByPkUserAndPkDoc(@Param(value = "pkUser")int pkUser,@Param(value = "pkDoc")int pkDoc){
        List<infoMessage>messages = messageService.findByPkUserAndPkDoc(pkUser,pkDoc);
        return new BaseResponse(messages);
    }
}
