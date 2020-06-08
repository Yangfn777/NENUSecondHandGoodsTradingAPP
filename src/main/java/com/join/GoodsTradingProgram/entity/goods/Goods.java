package com.join.GoodsTradingProgram.entity.goods;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 14:46 2020/5/16
 */
public class Goods {
    private int id;
    private int userId;
    private String type;//类型
    private String description;//描述
    private String picUrl;//图片
    private String path;
    private int degree;//新旧程度
    private float price;//价格

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", path='" + path + '\'' +
                ", degree=" + degree +
                ", price=" + price +
                '}';
    }
}
