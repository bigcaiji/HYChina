package com.syc.china.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author 汪梦瑶
 * @create  2020-01-07 18:43
 */
@Data
@Table(name = "hy_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String company;  //公司名称

    private String recommender;   //推荐人手机号



}
