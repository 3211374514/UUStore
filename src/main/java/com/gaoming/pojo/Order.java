package com.gaoming.pojo;

import java.util.Date;

public class Order {
    private Integer id;
    // 品牌名称

    // 企业名称
    private String companyName;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;
    // 价格
    private float price;
    //订单时间

    private String orderTime;

    private String brandName;

    private Integer orderSum;

    private String orderPeople;

    private String userName;

    private float sumPrice;

    private String beiZhu;

    private Integer orderId;

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

    public String getBeiZhu() {
        return beiZhu;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatus() {
        return status;
    }

    public float getPrice() {
        return price;
    }



    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
    }

    public void setOrderPeople(String orderPeople) {
        this.orderPeople = orderPeople;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getBrandName() {
        return brandName;
    }

    public Integer getOrderSum() {
        return orderSum;
    }

    public String getOrderPeople() {
        return orderPeople;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Order" +
                "orderTime=" + orderTime +
                ", brandName='" + brandName + '\'' +
                ", orderSum='" + orderSum + '\'' +
                ", orderPeople=" + orderPeople +
                ", userName='" + userName + "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status + '\'' + "price=" + price+'\'' + ",sumPrice=" + sumPrice+
                +'\'' + ",beiZhu=" + beiZhu+
                '}';
    }

}
