package com.recycle;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-05-10 0010.
 */
public class OrderBean implements Serializable {

    private int header;
    private String title;
    private String price;
    private String name;
    private String phone;
    private String state;

    public OrderBean() {
    }

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
