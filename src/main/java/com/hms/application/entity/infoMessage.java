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

    private int pkDoc;   //医生ID

    private String docName;   //医生姓名

    private String mFromUserStyle;   //发送者类型

    private int pkUser;    //用户ID

    private String userName;    //病人姓名

    private String mToUserStyle;    //接收者类型

    private String mStatus;   //接收状态

    private String mTime;    //发送时间


    public int getmId(){return mId;}

    public void setmId(int mId) {this.mId = mId;}

    public String getmMessage(){return mMessage;}

    public void setmMessage(String mMessage) {this.mMessage = mMessage;}

    public int getpkDoc(){return pkDoc;}

    public void setpkDoc(int pkDoc){this.pkDoc=pkDoc;}

    public String getDocName() {return docName;}

    public void setDocName(String docName){this.docName=docName;}

    public String getmFromUserStyle(){return mFromUserStyle;}

    public void setmFromUserStyle(String mFromUserStyle){this.mFromUserStyle = mFromUserStyle;}

    public int getpkUser() {return pkUser;}

    public void setpkUser(int pkUser){this.pkUser = pkUser;}

    public String getUserName(){return userName;}

    public void setUserName(String userName){this.userName=userName;}

    public String getmToUserStyle(){return mToUserStyle;}

    public void setmToUserStyle(String mToUserStyle){this.mToUserStyle = mToUserStyle;}

    public String getmStatus(){return mStatus;}

    public void setmStatus(String mStatus){this.mStatus = mStatus;}

    public String getmTime(){return mTime;}

    public void setmTime(String mTime){this.mTime = mTime;}
}
