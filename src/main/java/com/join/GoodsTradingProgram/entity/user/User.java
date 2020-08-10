package com.join.GoodsTradingProgram.entity.user;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 21:28 2020/5/9
 */
public class User {

    private int id;
    private String realname;
    private String username;
    private String password;
    private String profession;//专业
    private String stuno;//学号
    private String telnum;//手机号
    private String introduction;//个人简介
    private String headurl;//头像
    private String fileurl;//学生证图片

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getTelnum(){
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }


    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", realname='" + realname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profession='" + profession + '\'' +
                ", stuno='" + stuno + '\'' +
                ", telnum='" + telnum + '\'' +
                ", introduction='" + introduction + '\'' +
                ", headurl='" + headurl + '\'' +
                '}';
    }
}
