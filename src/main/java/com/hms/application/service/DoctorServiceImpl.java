package com.hms.application.service;

import com.hms.application.entity.infoDoc;
import com.hms.application.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * @Description ToDo
 * @Author Lyf
 * @Date 2019/4/2 20:49
 **/
@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public int checkDoctor(String docPhone, String docPassword) {
        List<infoDoc> docphones = doctorRepository.findByDocPhone(docPhone);
        List<infoDoc> docpasswords = doctorRepository.findByDocPassword(docPassword);
     if(docphones.isEmpty()  ){
            return 0;
        }
        else
         if(docpasswords.isEmpty()){
            return 2;
        }
        else{
            return 1;
        }


    }

    @Override
    public List<infoDoc> getdocNameAndpkDocAnddocPicture(String docPhone) {
        List<infoDoc> docNPP = doctorRepository.findByDocPhone(docPhone);
        return docNPP;
    }

}
