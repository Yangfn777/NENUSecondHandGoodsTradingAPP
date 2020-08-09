package com.join.GoodsTradingProgram.entity.msg;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:38 2020/8/9
 */
public class Msg {
    private int id;
    private int uid;
    private int gid;
    private float price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.util.Date date;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
