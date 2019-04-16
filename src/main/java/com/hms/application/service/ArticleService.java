package com.hms.application.service;

import com.hms.application.entity.infoArticle;

import java.util.List;

public interface ArticleService {
    List<infoArticle>findAll();

    //根据删除标志查找文章
    List<infoArticle>findByDm(String dm);
}
