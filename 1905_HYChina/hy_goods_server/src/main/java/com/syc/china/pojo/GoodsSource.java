package com.syc.china.pojo;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 */
@Data
@Table(name = "hy_goods_source")
public class GoodsSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Integer goodsType;
    private Integer weight;
    private String startPlace;
    private String endPlace;
    private Long cost;
    private Date createTime;
}
