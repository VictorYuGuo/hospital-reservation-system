package com.hms.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.hms.application.entity.InfoUser;
import com.hms.application.errors.ErrorEnum;
import com.hms.application.httpclient.AppInfo;
import com.hms.application.httpclient.HttpClientUtil;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/2 20:44
 **/

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 新用户首次打开小程序执行自动执行用户创建，若添加失败则返回失败信息
     *
     * @param wechat
     * @param type
     * @param time
     * @return
     */
    @PostMapping("/new")
    public BaseResponse newUser(@Param(value = "wechat") String wechat, @Param(value = "type") String type, @Param(value = "time") String time) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String jsonStr = "appid=" + AppInfo.appId + "&secret=" + AppInfo.appSecret + "&js_code=" + wechat + "&grant_type=authorization_code";
        String httpOrgCreateTestRtn = HttpClientUtil.doPost(url, jsonStr, "utf-8");
        JSONObject jsStr = JSONObject.parseObject(httpOrgCreateTestRtn);
        String openId = jsStr.getString("openid");
        System.out.println(jsStr);
        List<InfoUser>users = userService.findUser(openId);
        //若用户已经存在系统中，则直接返回请求成功,返回用户编码
        if(users.size()>0){
            return new BaseResponse(users.get(0).getUserId());
        }
        String result = userService.createNewUser(openId, type, time);
        if ("success".equals(result))
            return new BaseResponse();
        else
            return new BaseResponse(ErrorEnum.INSERT_FAIL);
    }

    /**
     * 通过查找用户判断用户是否存在在数据库里面，成功则返回查找到的用户对象，失败则返回错误信息
     *
     * @param wechat
     * @return
     */
    @GetMapping("/find")
    public BaseResponse findUser(@Param(value = "wechat") String wechat) {
        List<InfoUser> result = userService.findUser(wechat);
        BaseResponse baseResponse = new BaseResponse();
        if (result.size() > 0) {
            baseResponse.setData(result);
            return baseResponse;
        } else {
            baseResponse.setErrCode(ErrorEnum.OPERATION_FAIL.getErrCode());
            baseResponse.setErrMsg(ErrorEnum.OPERATION_FAIL.getErrMsg());
            return baseResponse;
        }
    }

    @PostMapping("/update")
    public BaseResponse updateUser(@Param(value = "name") String name, @Param(value = "phone") String phone, @Param(value = "sex") String sex, @Param(value = "wechat") String wechat) {
        String result = userService.updateUser(name, phone, sex, wechat);
        return new BaseResponse();
    }

}
