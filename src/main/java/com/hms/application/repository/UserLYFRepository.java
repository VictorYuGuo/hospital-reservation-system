package com.hms.application.repository;

import com.hms.application.entity.InfoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.sampled.Line;
import java.util.List;

public interface UserLYFRepository extends JpaRepository<InfoUser,String>{
    @Transactional
    @Modifying
    @Query(value = "Select user_id,user_name From info_user WHERE user_id =:userId",nativeQuery = true)
    List<Object[]> selectuserinfo(@Param(value = "userId") int userId);
}
