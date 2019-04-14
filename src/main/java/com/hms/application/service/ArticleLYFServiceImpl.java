package com.hms.application.service;

import com.hms.application.entity.InfoUser;
import com.hms.application.entity.infoDoc;
import com.hms.application.entity.infoArticle;
import com.hms.application.repository.ArticleLYFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.List;

/**
 * @Description ToDo
 * @Author Lyf
 * @Date 2019/4/2 20:49
 **/
@Service
public class ArticleLYFServiceImpl implements ArticleLYFService{
    @Autowired
    ArticleLYFRepository articleRepository;

    @Override
    public List<infoArticle> selectpic() {
        List<infoArticle> artpicinfo = articleRepository.selectpic();
        return artpicinfo;
    }

        @Override
        public List<infoArticle> selectart(){
            List<infoArticle> artinfo = articleRepository.selectart();
            return artinfo;
    }

    @Override
    public List<infoArticle> selectartinfo(int pkArticle){
        List<infoArticle> artinfo = articleRepository.selectartinfo(pkArticle);
        return artinfo;
    }

}
