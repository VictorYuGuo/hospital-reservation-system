package com.hms.application.service;


import com.hms.application.entity.InfoUser;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoAppoint;

import java.util.List;

public interface DoctorLYFService {
    //用户发送电话和密码验证身份
    public int checkDoctor(String docPhone,String docPassword);

    //通过phone请求docName，DocUrl，PkDoc
  //  public List<infoDoc> getdocNameAndpkDocAnddocPicture(String docPhone);

    //通过phone请求医生信息
    public List<infoDoc>findByDocPhone(String docPhone);


}
