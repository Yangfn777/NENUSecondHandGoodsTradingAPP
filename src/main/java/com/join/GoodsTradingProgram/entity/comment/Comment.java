package com.join.GoodsTradingProgram.entity.comment;

import java.util.Date;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 19:24 2020/5/26
 */
public class Comment {
    private int id;
    private int goodsId;
    private int sellerId;
    private int buyerId;
    private String content;
    private Date times;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }
}
