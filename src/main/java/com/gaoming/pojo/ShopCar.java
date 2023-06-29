package com.gaoming.pojo;

public class ShopCar {
    // carid 主键
    private Integer carId;
    // 商品名称
    private String shopName;
    // 企业名称
    private String companyName;
    // 价格
    private float price;
    // 购买数量
    private Integer shopSum;
    // 用户名
    private String customer;


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getShopSum() {
        return shopSum;
    }

    public void setShopSum(Integer shopSum) {
        this.shopSum = shopSum;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "carId=" + carId +
                ", shopName='" + shopName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", price=" + price +
                ", shopSum='" + shopSum + '\'' +
                ", customer=" + customer  +
                '}';
    }
}
