package com.hms.application.repository;

import com.hms.application.entity.infoArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleLYFRepository extends JpaRepository<infoArticle,String> {

    @Transactional
    @Modifying
    @Query(value = "Select * From info_article WHERE pk_article<4 ",nativeQuery = true)
    List<infoArticle> selectpic();

    @Transactional
    @Modifying
    @Query(value = "Select * From info_article WHERE pk_article",nativeQuery = true)
    List<infoArticle> selectart();

    @Transactional
    @Modifying
    @Query(value = "Select * From info_article WHERE pk_article=:pkArticle",nativeQuery = true)
    List<infoArticle> selectartinfo(@Param(value="pkArticle")int pkArticle);




}
