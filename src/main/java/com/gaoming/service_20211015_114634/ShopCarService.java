package com.gaoming.service_20211015_114634;

import com.gaoming.pojo.ShopCar;

import java.util.List;

public interface ShopCarService {

    //List<Supp> selectAll(String companyName);

    List<ShopCar> selectAll();

    void add(ShopCar supp);

    void updateOrdered(ShopCar shopcar);

}
