package com.hms.application.bean;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/8 0:50
 **/

public class CurrentAppointment {
    private String appointDate;
    private String appointClinic;
    private String appointType;
    private String docName;

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
}
