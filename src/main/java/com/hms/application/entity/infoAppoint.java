package com.hms.application.entity;

import javax.persistence.*;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/3/26 21:52
 * 预约信息实体类
 **/

@Entity
@Table(name = "info_appoint")
public class infoAppoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointId;       //表主键

    private int userCode;        //用户编码

    private String userName;        //用户姓名

    private String userType;        //用户类型

    private String userPhone;       //电话号码

    private String appointClinic;   //预约诊所

    private String appointType;     //预约服务类型

    private String appointDate;     //预约日期

    private int appointDoc;      //预约医师pk

    private String appointInf;      //病情简述

    private String creationTime;    //创建日期

    private String dm;               //是否取消标记

    private String end;              //预约是否完成诊疗标记

    public int getAppointId() {
        return appointId;
    }

    public void setAppointId(int appointId) {
        this.appointId = appointId;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAppointClinic() {
        return appointClinic;
    }

    public void setAppointClinic(String appointClinic) {
        this.appointClinic = appointClinic;
    }

    public String getAppointType() {
        return appointType;
    }

    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public int getAppointDoc() {
        return appointDoc;
    }

    public void setAppointDoc(int appointDoc) {
        this.appointDoc = appointDoc;
    }

    public String getAppointInf() {
        return appointInf;
    }

    public void setAppointInf(String appointInf) {
        this.appointInf = appointInf;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
