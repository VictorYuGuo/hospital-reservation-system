package com.hms.application.controller;
import com.hms.application.entity.infoArticle;
import com.hms.application.entity.infoDoc;
import com.hms.application.response.BaseResponse;
import com.hms.application.service.ArticleLYFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleLYFController {
    @Autowired
    ArticleLYFService articleService;

    /**
     * *
     * @return
     */
    @PostMapping("/articlepic")
    public BaseResponse selectpic(){
        List<infoArticle> artpicinfo = articleService.selectpic();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(artpicinfo);
        return baseResponse;
    }

    /**
     * *
     * @return
     */
    @PostMapping("/articleart")
    public BaseResponse selectart(){
        List<infoArticle> artartinfo = articleService.selectart();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(artartinfo);
        return baseResponse;
    }

    /**
     * *
     * @param pkarticle
     * @return
     */
    @PostMapping("/articleartinfo")
    public BaseResponse selectartinfo(@Param(value="pkarticle")int pkarticle){
        List<infoArticle> artinfo = articleService.selectartinfo(pkarticle);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(artinfo);
        return baseResponse;
    }
}
