package com.hms.application.controller;
import com.hms.application.entity.infoMessage;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.InfoUser;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.MessageLYFService;
import com.hms.application.service.UserLYFService;
import com.hms.application.bean.MessageLYF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.Line;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageLYFController {
    @Autowired
    MessageLYFService messageService;
    @Autowired
    UserLYFService userService;

    /**
     * 用户用pkdoc请求预约信息
     * *
     * @param pkdoc
     * @return
     */
    @PostMapping("/usermesinfo")
    public BaseResponse getmesusermesinfo(@Param(value ="pkdoc")int pkdoc){
       List<infoMessage> messageinfo = messageService.selectuser(pkdoc);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(messageinfo);
        return baseResponse;
    }

    /**
     * 用户用pkdoc请求预约信息
     * *
     * @param pkdoc
     * @return
     */
    @PostMapping("/userinfo")
    public BaseResponse getmesuserinfo(@Param(value ="pkdoc")int pkdoc){
        List<infoMessage> messageinfo = messageService.selectuser(pkdoc);
 //       ArrayList<MessageLYF> histories  = new ArrayList();
        List histories = new ArrayList<MessageLYF>();
       for(int i=0;i<messageinfo.size();i++){
        //                infoMessage message = messageinfo.get(0);
           InfoUser userinfo = userService.findByUserId(messageinfo.get(i).getpkUser());

            MessageLYF messageLYF = new MessageLYF();
                     //    appointHistory.setAppointClinic(appoints.get(i).getAppointClinic());
            messageLYF.setPkUser(messageinfo.get(i).getpkUser());
            messageLYF.setUserName(userinfo.getUserName());
            messageLYF.setMessage(messageinfo.get(i).getmMessage());
           messageLYF.setmFromUserStyle(messageinfo.get(i).getmFromUserStyle());
           messageLYF.setmToUserStyle(messageinfo.get(i).getmToUserStyle());
           messageLYF.setmStatus(messageinfo.get(i).getmStatus());

            histories.add(messageLYF);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(histories);
        return baseResponse;
}

    /**
     * 用户用pkdoc请求预约信息
     * *
     * @param pkdoc
     * @param pkuser
     * @return
     */
    @PostMapping("/mesinfo")
    public BaseResponse getmesinfo(@Param(value ="pkdoc")int pkdoc,@Param(value = "pkuser")int pkuser){
        List<infoMessage> messageinfo = messageService.selectmes(pkdoc,pkuser);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(messageinfo);
        return baseResponse;
    }

    /**
     * 用户用pkdoc请求预约信息
     * *
     * @param pkdoc
     * @param pkuser
     * @return
     */
    @PostMapping("/changestatus")
    public BaseResponse changestatus(@Param(value ="pkdoc")int pkdoc,@Param(value = "pkuser")int pkuser){
        String result = messageService.changestatus(pkdoc,pkuser);
        return  new BaseResponse();
    }




}
