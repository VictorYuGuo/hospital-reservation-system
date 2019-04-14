package com.hms.application.repository;

import com.hms.application.entity.infoMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageLYFRepository extends JpaRepository<infoMessage,String> {
 //   @Transactional
 //   @Modifying
  //  @Query(value = "Select * From info_message WHERE  m_id in(select max(m_id) as m_id from info_message where pk_doc = :pkDoc and m_to_user_style = 0 group by pk_user) order by m_status",nativeQuery = true)
  //  List<infoMessage> selectuser(@Param(value = "pkDoc") int pkDoc);

    @Transactional
    @Modifying
    @Query(value = "Select * From info_message WHERE  m_id in(select max(m_id) as m_id from info_message where pk_doc = :pkDoc group by pk_user) order by m_status",nativeQuery = true)
    List<infoMessage> selectuser(@Param(value = "pkDoc") int pkDoc);


    @Transactional
    @Modifying
    @Query(value = "Select * From info_message WHERE  pk_doc=:pkDoc and pk_user =:pkUser",nativeQuery = true)
    List<infoMessage> selectmes(@Param(value = "pkDoc") int pkDoc,@Param(value = "pkUser") int pkUser);

    @Transactional
    @Modifying
    @Query(value = "Update info_message set m_status = 1 where pk_user =:pkUser and pk_doc =:pkDoc and m_to_user_style = 0",nativeQuery = true)
    void changestatus(@Param(value = "pkDoc") int pkDoc,@Param(value = "pkUser") int pkUser);

}
