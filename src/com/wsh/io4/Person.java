package com.wsh.io4;

import java.io.Serializable;

/**
 * @Description:
 * @Author: weishihuai
 * @Date: 2018/11/3 14:18
 */
public class Person implements Serializable {

    private String id;
    private String name;
    private transient Double height;

    public Person(String id, String name, Double height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
