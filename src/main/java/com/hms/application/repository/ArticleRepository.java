package com.hms.application.repository;

import com.hms.application.entity.infoArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 资讯信息数据库接口
 */
public interface ArticleRepository extends JpaRepository<infoArticle,String> {
    //根据删除标志查找
    List<infoArticle>findByDm(String dm);
}
