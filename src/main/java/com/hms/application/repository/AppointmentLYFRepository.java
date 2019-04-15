package com.hms.application.repository;

import com.hms.application.entity.infoAppoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppointmentLYFRepository extends JpaRepository<infoAppoint,String> {
    //根据预约医生名字获取预约表信息
    List<infoAppoint> findByAppointDoc(int AppointDoc);

    @Transactional
    @Modifying
    @Query(value = "Select * From info_appoint WHERE appoint_doc =:appointDoc AND appoint_date LIKE :appointDate% Order by end , appoint_date",nativeQuery = true)
    List<infoAppoint> selectNNP(@Param(value = "appointDoc") int appointDoc,@Param(value = "appointDate") String appointDate);

    @Transactional
    @Modifying
    @Query(value = "Select * From info_appoint WHERE user_name =:userName AND appoint_date LIKE :appointDate% and dm=0",nativeQuery = true)
    List<infoAppoint> selectappoint(@Param(value = "userName") String userName,@Param(value = "appointDate") String appointDate);

    @Transactional
    @Modifying
    @Query(value = "Update info_appoint set end = :end where appoint_id = :appointId and dm=0",nativeQuery = true)
    void updateEnd(@Param(value = "appointId")int appointId,@Param(value = "end") String end);




}
