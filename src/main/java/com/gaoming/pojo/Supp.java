package com.gaoming.pojo;

public class Supp {

    private String companyName;

    private String phone;

    private String province;

    private String city;

    private String address;

    private String zip;

    private Integer suppId;

    private String beiZhu;

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

    public String getBeiZhu() {
        return beiZhu;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setSuppId(Integer suppId) {
        this.suppId = suppId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }



    public String getZip() {
        return zip;
    }

    public Integer getSuppId() {
        return suppId;
    }

    public String toString() {
        return "Supp" +'{'+
                "companyName=" + companyName +
                ", phone='" + phone + '\'' +
                ", province='" + province + '\'' +
                ", city=" + city +
                ", address='" + address +
                ", zip='" + zip +
                ", suppId='" + suppId +
                ", beiZhu='" + beiZhu +
                '}';
    }

}
