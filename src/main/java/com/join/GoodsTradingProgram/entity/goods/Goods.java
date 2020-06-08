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
    private String title;//标题
    private int view;//浏览量
    private float price;//价格

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
