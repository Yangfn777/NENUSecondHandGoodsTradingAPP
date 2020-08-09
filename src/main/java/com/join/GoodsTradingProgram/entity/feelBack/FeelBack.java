package com.join.GoodsTradingProgram.entity.feelBack;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 21:16 2020/8/9
 */
public class FeelBack {

    private int id;
    private int uid;
    private int gid;
    private String str;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.util.Date date;
    private String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FeelBack{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", str='" + str + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
