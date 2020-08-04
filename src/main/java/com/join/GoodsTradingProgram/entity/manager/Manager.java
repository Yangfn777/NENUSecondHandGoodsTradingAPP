package com.join.GoodsTradingProgram.entity.manager;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 21:30 2020/5/16
 */
public class Manager {

    private int id;
    private String managerName;
    private String password;
    private String headurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", managerName='" + managerName + '\'' +
                ", password='" + password + '\'' +
                ", headurl='" + headurl + '\'' +
                '}';
    }
}
