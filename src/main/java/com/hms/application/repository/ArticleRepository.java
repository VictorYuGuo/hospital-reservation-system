package com.hms.application.repository;

import com.hms.application.entity.infoArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 资讯信息数据库接口
 */
public interface ArticleRepository extends JpaRepository<infoArticle,String> {

}
