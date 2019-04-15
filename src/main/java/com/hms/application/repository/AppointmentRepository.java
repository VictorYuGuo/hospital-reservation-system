package com.hms.application.repository;

import com.hms.application.entity.infoAppoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 预约信息表数据库操作接口
 */
public interface AppointmentRepository extends JpaRepository<infoAppoint,String> {
    //根据预约编号查找预约信息
    infoAppoint findByAppointId(int appointId);
    //根据预约日期查找预约信息
    List<infoAppoint>findByAppointDate(String appointDate);
    //根据预约日期和是否删除标志查找预约信息
    List<infoAppoint>findByAppointDateAndDm(String appointDate,String dm);
    //根据预约医生和是否删除标志查找预约信息
    List<infoAppoint>findByAppointDocAndDm(int appointDoc,String dm);
    //根据用户编码、日期、删除标记查找
    List<infoAppoint>findByUserCodeAndAppointDateContainingAndDm(int userCode,String appointDate,String dm);
    //根据用户编码、日期、删除标记、是否完成标志查找
    List<infoAppoint>findByUserCodeAndAppointDateContainingAndDmAndEnd(int userCode,String appointDate,String dm,String end);
    //根据用户编码和是否删除标记查找
    List<infoAppoint>findByUserCodeAndDm(int userCode,String dm);
    //根据预约编号更新预约信息
    @Transactional
    @Modifying
    @Query(value = "update info_appoint set appoint_clinic = ?1,appoint_type=?2,appoint_date=?3,appoint_doc=?4,appoint_inf=?5", nativeQuery = true)
    int updateAppoint(String appointClinic,String appointType,String appointDate,int appointDoc,String appointInf);

    //根据预约编号更新预约信息
    @Transactional
    @Modifying
    @Query(value = "update info_appoint set dm= '1' where appoint_date like concat('%',?1,'%') and user_code=?2", nativeQuery = true)
    int deleteAppoint(String appointDate,int userCode);
}
