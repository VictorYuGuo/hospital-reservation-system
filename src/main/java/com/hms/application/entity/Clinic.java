package com.hms.application.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 分诊所管理实体类
 */
@Entity
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clinicId;                                 // 主键，分诊所Id，自增

    @Column(length = 32)
    private String clinicNumber;                              // 分诊所编号

    @Column(length = 64)
    private String docClinic;                                 // 分诊所名称

    private String clinicAddress;                             // 分诊所地址

    private Date clinicTime;                                  // 分诊所创建时间

    private String dm;                                        // 分诊所删除标记

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicNumber() {
        return clinicNumber;
    }

    public void setClinicNumber(String clinicNumber) {
        this.clinicNumber = clinicNumber;
    }

    public String getDocClinic() {
        return docClinic;
    }

    public void setDocClinic(String docClinic) {
        this.docClinic = docClinic;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public Date getClinicTime() {
        return clinicTime;
    }

    public void setClinicTime(Date clinicTime) {
        this.clinicTime = clinicTime;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }
}
