package com.hms.application.controller;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/7 17:47
 **/

import com.hms.application.bean.AppointHistory;
import com.hms.application.bean.CurrentAppointment;
import com.hms.application.bean.Subject;
import com.hms.application.bean.SubjectDoctor;
import com.hms.application.entity.InfoUser;
import com.hms.application.entity.infoAppoint;
import com.hms.application.entity.infoDoc;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.AppointService;
import com.hms.application.service.DoctorService;
import com.hms.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.Line;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appoint")
public class AppointController {
    @Autowired
    AppointService appointService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    UserService userService;

    @PostMapping("/new")
    public BaseResponse newAppoint(@Param(value = "userCode")int userCode,
                                   @Param(value = "creationTime")String creationTime,
                                   @Param(value = "clinic")String clinic,
                                   @Param(value = "appointDate")String appointDate,
                                   @Param(value = "pkDoc")int pkDoc,
                                   @Param(value = "subject")String subject,
                                   @Param(value = "appointInfo")String appointInfo){
        List<infoAppoint>appoints = appointService.findByUserCodeAndDateAndDmAndEnd(userCode,appointDate,"0","0");
        if(appoints.size()>0){
            return new BaseResponse("fail");
        }
        else {
            InfoUser user = userService.findByUserCode(userCode);
            infoAppoint infoAppoint = new infoAppoint();
            infoAppoint.setUserCode(userCode);
            infoAppoint.setUserName(user.getUserName());
            infoAppoint.setUserType(user.getUserType());
            infoAppoint.setUserPhone(user.getUserPhone());
            infoAppoint.setCreationTime(creationTime);
            infoAppoint.setAppointClinic(clinic);
            infoAppoint.setAppointDate(appointDate);
            infoAppoint.setAppointDoc(pkDoc);
            infoAppoint.setAppointType(subject);
            infoAppoint.setAppointInf(appointInfo);
            infoAppoint.setDm("0");
            infoAppoint.setEnd("0");
            appointService.insert(infoAppoint);
            return new BaseResponse("success");
        }
    }

    @GetMapping("/find/type=userCode&date&dm")
    public BaseResponse findByUserCodeAndDateAndDm(@Param(value = "userCode")int userCode,@Param(value = "date")String date,@Param(value = "dm")String dm){
//        List<infoAppoint>appoints = appointService.findByUserCodeAndDateAndDm(userCode,date,dm);
        List<infoAppoint>appoints = appointService.findByUserCodeAndDateAndDmAndEnd(userCode,date,dm,"0");
        if(appoints.size()>0) {
            infoAppoint appoint = appoints.get(0);
            infoDoc doctor = doctorService.findbyPkDoc(appoint.getAppointDoc());
            CurrentAppointment currentAppointment = new CurrentAppointment();
            currentAppointment.setAppointClinic(appoint.getAppointClinic());
            currentAppointment.setAppointDate(appoint.getAppointDate());
            currentAppointment.setAppointType(appoint.getAppointType());
            currentAppointment.setDocName(doctor.getDocName());
            return new BaseResponse(currentAppointment);
        }
        else{
            return new BaseResponse();
        }
    }

    @GetMapping("/find/type=userCode&dm")
    public BaseResponse findByUserCodeAndDm(@Param(value = "userCode")int userCode,@Param(value = "dm")String dm){
        List<infoAppoint>appoints = appointService.findByUserCodeAndDm(userCode,dm);
        List appointHistories = new ArrayList<AppointHistory>();
        for(int i=0;i<appoints.size();i++){
            AppointHistory appointHistory = new AppointHistory();
            appointHistory.setAppointClinic(appoints.get(i).getAppointClinic());
            appointHistory.setAppointDate(appoints.get(i).getAppointDate());
            appointHistory.setAppointType(appoints.get(i).getAppointType());
            infoDoc doctor = doctorService.findbyPkDoc(appoints.get(i).getAppointDoc());
            appointHistory.setAppointDocName(doctor.getDocName());
            appointHistories.add(appointHistory);
        }
        return new BaseResponse(appointHistories);
    }

    @GetMapping("/get/subject&doctor")
    public BaseResponse getSubjectAndDoctor(){
        List<String>subjects = doctorService.findAllSubject();
        List returnSubjects = new ArrayList<Subject>();
        for(int i=0;i<subjects.size();i++){
            Subject subject = new Subject();
            subject.setDocName(subjects.get(i));
            returnSubjects.add(subject);
        }
        List<infoDoc>doctors = doctorService.findAll();
        SubjectDoctor subjectDoctor = new SubjectDoctor();
        subjectDoctor.setDoctors(doctors);
        subjectDoctor.setSubjects(returnSubjects);
        return new BaseResponse(subjectDoctor);
    }

    @PostMapping("/delete")
    public BaseResponse deleteAppoint(@Param(value = "appointDate")String appointDate,@Param(value = "userCode")int userCode){
        appointService.deleteAppoint(appointDate,userCode);
        return new BaseResponse();
    }
}
