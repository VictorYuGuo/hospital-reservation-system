package com.hms.application.service;

import com.hms.application.entity.infoArticle;
import com.hms.application.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/14 23:15
 **/

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleRepository articleRepository;
    @Override
    public List<infoArticle> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<infoArticle> findByDm(String dm) {
        return articleRepository.findByDm(dm);
    }
}
