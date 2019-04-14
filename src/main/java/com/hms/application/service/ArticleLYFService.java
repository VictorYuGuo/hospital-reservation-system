package com.hms.application.service;

import com.hms.application.entity.infoArticle;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ArticleLYFService {

    public List<infoArticle> selectpic();

    public List<infoArticle> selectart();

    public List<infoArticle> selectartinfo(int pkArticle);
}
