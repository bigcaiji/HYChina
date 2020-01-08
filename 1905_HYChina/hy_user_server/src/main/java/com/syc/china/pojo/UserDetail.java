package com.syc.china.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 汪梦瑶
 * @create  2020-01-07 18:48
 */
@Data
@Table(name = "hy_user_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long detailId;

    private Integer roleId;  /*角色id
                                0.货主-生产企业 1.货主-经营企业 2.车主-个人车主 */

    private Integer actionId;  /*行为id
                                0.车主-企业车主 1.物流信息公司 2.国际物流公司 3.船舶运输 4.火车运输 5.航空运输 6.其他'*/

    private Long userId;  //用户id

    private String company;  //公司：个人车主不需要用到该字段

    private String username;

    private String phone;

    private String idNumber; //身份证号 只有企业车主、个人车主需要该字段

    private String address; //地址

    private String productCategory;  //产品类别 只有货主-生产企业，货主-经营企业需要用到该字段

    private String carInfo;  //车辆信息 只有企业车主、个人车主才需要用到该字段

    private String mainBusiness;  //主营业务  物流信息公司、国际物流公司、船舶运输、火车运输、航空运输需要用到该字段

    private String qualification;  //资质

    private String email;

    private String wechat;   //微信

    private String qq;


}
