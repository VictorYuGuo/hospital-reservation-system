package com.hms.application.bean;

import com.hms.application.entity.infoDoc;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/10 0:48
 **/

public class SubjectDoctor {
    private List<Subject> subjects;//所有科室
    private List<infoDoc> doctors;//所有医生信息

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<infoDoc> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<infoDoc> doctors) {
        this.doctors = doctors;
    }
}
