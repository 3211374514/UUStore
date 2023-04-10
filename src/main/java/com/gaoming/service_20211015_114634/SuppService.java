package com.gaoming.service_20211015_114634;

import com.gaoming.pojo.Brand;
import com.gaoming.pojo.Order;
import com.gaoming.pojo.Supp;

import java.util.List;

public interface SuppService {

    //List<Supp> selectAll(String companyName);

    List<Supp> selectAll();

    void add(Supp supp);

}
