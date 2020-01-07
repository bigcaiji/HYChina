package com.syc.china.vo;

import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class PageResult<T> {
    private List<T> items;  //总记录

    private Long total;  //总条数

    private Long totalPage;   //总页数

    public PageResult() {
    }

    public PageResult(List<T> items, Long total, Long totalPage) {
        this.items = items;
        this.total = total;
        this.totalPage = totalPage;
    }

    public PageResult(List<T> items, Long total) {
        this.items = items;
        this.total = total;
    }
}
