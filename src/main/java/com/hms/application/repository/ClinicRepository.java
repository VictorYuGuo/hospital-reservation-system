package com.hms.application.repository;

import com.hms.application.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicRepository extends JpaRepository<Clinic,Integer> {
    //根据删除标志查找分诊所
    List<Clinic>findByDm(String dm);
}
