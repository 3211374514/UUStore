package com.gaoming.pojo;

public class BrandNameBean {

    String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "value="+value+",";
    }

}
