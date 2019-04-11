package com.hms.application.repository;

import com.hms.application.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic,Integer> {
}
