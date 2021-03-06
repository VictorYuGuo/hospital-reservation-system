package com.hms.application.bean;

/**
 * @Description ToDo
 * 封装返回就诊记录的信息
 * @Author Ly
 * @Date 2019/4/7 17:10
 **/

public class ReportHistory {
    private String reportDate;

    private String clinic;

    private String subject;

    private String docName;

    private int billId;

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }
}
