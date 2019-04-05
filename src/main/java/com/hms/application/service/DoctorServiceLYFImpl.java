package com.hms.application.service;

import com.hms.application.entity.InfoUser;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoAppoint;
import com.hms.application.repository.DoctorLYFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.List;

/**
 * @Description ToDo
 * @Author Lyf
 * @Date 2019/4/2 20:49
 **/
@Service
public class DoctorServiceLYFImpl implements DoctorLYFService {
    @Autowired
    DoctorLYFRepository doctorRepository;

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
    public List<infoDoc> findByDocPhone(String docPhone){
        List<infoDoc> docinfo = doctorRepository.findByDocPhone(docPhone);
        return docinfo;
    }

 /*   @Override
    public List<infoDoc> getdocNameAndpkDocAnddocPicture(String docPhone) {
        List<infoDoc> docNPP = doctorRepository.findByDocPhone(docPhone);
        return docNPP;
    }
    */


}
