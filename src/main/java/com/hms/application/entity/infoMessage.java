package com.hms.application.entity;

import javax.persistence.*;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/3/26 22:05
 * 聊天信息实体类
 **/

@Entity
@Table(name = "info_message")
public class infoMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mId;    //表主键

    private String mMessage;   //信息内容

    private int mFromUserId;   //发送者ID

    private String mFromUserStyle;   //发送者类型

    private int mToUserId;    //接收者ID

    private String mToUserStyle;    //接收者类型

    private String mStatus;   //接收状态


    public int getmId(){return mId;}

    public void setmId(int mId) {this.mId = mId;}

    public String getmMessage(){return mMessage;}

    public void setmMessage(String mMessage) {this.mMessage = mMessage;}

    public int getmFromUserId(){return mFromUserId;}

    public void setmFromUserId(int mFromUserId){this.mFromUserId = mFromUserId;}

    public String getmFromUserStyle(){return mFromUserStyle;}

    public void setmFromUserStyle(String mFromUserStyle){this.mFromUserStyle = mFromUserStyle;}

    public int getmToUserId() {return mToUserId;}

    public void setmToUserId(int mToUserId){this.mToUserId = mToUserId;}

    public String getmToUserStyle(){return mToUserStyle;}

    public void setmToUserStyle(String mToUserStyle){this.mToUserStyle = mToUserStyle;}

    public String getmStatus(){return mStatus;}

    public void setmStatus(String mStatus){this.mStatus = mStatus;}
}
