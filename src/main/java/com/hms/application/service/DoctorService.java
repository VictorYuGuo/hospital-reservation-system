package com.hms.application.service;


import com.hms.application.entity.infoDoc;

import java.util.List;

public interface DoctorService {
    //用户发送电话和密码验证身份
    public int checkDoctor(String docPhone,String docPassword);

    //通过phone请求docName，DocUrl，PkDoc
    public List<infoDoc> getdocNameAndpkDocAnddocPicture(String docPhone);


}
