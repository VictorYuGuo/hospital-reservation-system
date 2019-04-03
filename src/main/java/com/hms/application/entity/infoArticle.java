package com.hms.application.entity;

import javax.persistence.*;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/3/26 22:27
 * 资讯信息实体类
 **/

@Entity
@Table(name = "info_article")
public class infoArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkArticle;       //表主键

    private String artTitle;        //资讯标题

    private String artPicture;      //图片路径

    private String artText;         //相关文本

    private String artLink;         //资讯链接地址

    private String creationTime;    //创建时间

    private String dm;               //删除标记

    public int getPkArticle() {
        return pkArticle;
    }

    public void setPkArticle(int pkArticle) {
        this.pkArticle = pkArticle;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtPicture() {
        return artPicture;
    }

    public void setArtPicture(String artPicture) {
        this.artPicture = artPicture;
    }

    public String getArtText() {
        return artText;
    }

    public void setArtText(String artText) {
        this.artText = artText;
    }

    public String getArtLink() {
        return artLink;
    }

    public void setArtLink(String artLink) {
        this.artLink = artLink;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }
}
