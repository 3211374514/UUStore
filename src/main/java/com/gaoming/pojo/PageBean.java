package com.gaoming.pojo;

import java.util.List;

public class PageBean <T>{
    //总记录数
    private int totalCount;
    //当前页数据
    private List<T> rows;


    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<T> getRows() {
        return rows;
    }




}
