package com.wsh.serialize;

import java.io.Serializable;

/**
 * @Description: 会员实体类
 * @Author: weishihuai
 * @Date: 2018/11/4 19:41
 * 说明： 实现序列化接口Serializable
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员ID
     */
    private String memberId;
    /**
     * 会员姓名
     */
    private String name;
    /**
     * 体重(注意: 这里使用了transient关键字修饰)
     */
    private transient Double weight;
    /**
     * 身高(注意: 静态属性、类属性)
     */
    private static Double height = 165.5D;
    /**
     * 手机号码
     */
    private String mobile;

    public Member(String memberId, String name, Double weight) {
        this.memberId = memberId;
        this.name = name;
        this.weight = weight;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public static Double getHeight() {
        return height;
    }

    public static void setHeight(Double height) {
        Member.height = height;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
