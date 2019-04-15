package com.hms.application.bean;

/**
 * @Description ToDo
 * @Author Ly
 * @Date 2019/4/8 0:50
 **/
public class MessageLYF {
    private int pkUser;
    private String userName;
    private String Message;
    private String mFromUserStyle;
    private String mToUserStyle;
    private String mStatus;

    public int getPkUser(){return pkUser;}

    public void setPkUser(int pkUser) {this.pkUser = pkUser;}


    public String getUserName(){return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getMessage(){return Message;}

    public void setMessage(String Message) {this.Message = Message;}

    public String getmFromUserStyle() {return mFromUserStyle;}

    public void setmFromUserStyle(String mFromUserStyle) {this.mFromUserStyle=mFromUserStyle;}

    public String getmToUserStyle(){return mToUserStyle;}

    public void setmToUserStyle(String mToUserStyle){this.mToUserStyle=mToUserStyle;}

    public String getmStatus(){return mStatus;}

    public void setmStatus(String mStatus){this.mStatus = mStatus;}

}
