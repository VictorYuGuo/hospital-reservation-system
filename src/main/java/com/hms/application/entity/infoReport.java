package com.hms.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/3/26 22:32
 * 就诊报告实体类
 **/

@Entity
@Table(name = "info_report")
public class infoReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;     //单据号

    private int appointId;   //预约表ID

    private int userCode;    //用户编码

    private String userName;    //用户姓名

    private String reportSubject;//就诊项目

    private String reportResult;//诊断结果

    private String reportDate;  //就诊日期

    private int pkDoc;     //医生姓名

    private String docName;

    private String reportMoney;//消费金额

    private String creationTime;//创建日期

    private String dm;           //删除标记

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAppointId()  { return appointId;}

    public void setAppointId(int appointId) {this.appointId = appointId;}

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

    public String getReportSubject() {
        return reportSubject;
    }

    public void setReportSubject(String reportSubject) {
        this.reportSubject = reportSubject;
    }

    public String getReportResult() {
        return reportResult;
    }

    public void setReportResult(String reportResult) {
        this.reportResult = reportResult;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public int getpkDoc() {
        return pkDoc;
    }

    public void setpkDoc(int pkDoc) {
        this.pkDoc = pkDoc;
    }

    public String getDocName() {return docName;}

    public void setDocName(String docName) {this.docName = docName;}

    public String getReportMoney() {
        return reportMoney;
    }

    public void setReportMoney(String reportMoney) {
        this.reportMoney = reportMoney;
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
}
