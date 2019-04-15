package com.hms.application.controller;

import com.hms.application.entity.infoArticle;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/14 23:17
 **/

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping(value = "/find")
    public BaseResponse findAll(){
        List<infoArticle> articles = articleService.findAll();
        return new BaseResponse(articles);
    }
}
