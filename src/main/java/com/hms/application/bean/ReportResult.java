package com.hms.application.bean;

/**
 * @Description ToDo
 * 封装查找就诊报告的返回结果
 * @Author Ly
 * @Date 2019/4/7 14:11
 **/

public class ReportResult {
    private String subject;//就诊科室
    private String docName;//就诊医生姓名
    private String docUrl;//医生照片url
    private String reportResult;//就诊结果

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

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getReportResult() {
        return reportResult;
    }

    public void setReportResult(String reportResult) {
        this.reportResult = reportResult;
    }
}
