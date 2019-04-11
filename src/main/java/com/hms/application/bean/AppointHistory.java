package com.hms.application.bean;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/11 22:26
 **/

public class AppointHistory {
    private String appointDate;
    private String appointClinic;
    private String appointType;
    private String appointDocName;

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

    public String getAppointDocName() {
        return appointDocName;
    }

    public void setAppointDocName(String appointDocName) {
        this.appointDocName = appointDocName;
    }
}
