/*
Navicat MySQL Data Transfer

Source Server         : wmy
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : hychina

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2020-01-06 21:36:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hy_user
-- ----------------------------
DROP TABLE IF EXISTS `hy_user`;
CREATE TABLE `hy_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(24) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `recommender` varchar(24) DEFAULT NULL COMMENT '推荐人手机号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user_id：id主键自增长\r\nusername：姓名\r\npassword：密码\r\nphone：手机号\r\nemail：邮箱\r\ncompany：公司名称\r\nrecommender：推荐人姓名';

-- ----------------------------
-- Records of hy_user
-- ----------------------------

-- ----------------------------
-- Table structure for hy_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `hy_user_detail`;
CREATE TABLE `hy_user_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL COMMENT '1.货主-生产企业\r\n2.货主-经营企业\r\n3.车主-个人车主\r\n4.车主-企业车主\r\n5.物流信息公司\r\n6.国际物流公司\r\n7.船舶运输\r\n8.火车运输\r\n9.航空运输\r\n10.其他',
  `user_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL COMMENT '个人车主不需要用到该字段',
  `username` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL COMMENT '身份证号 //只有企业车主、个人车主需要该字段',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `product_category` varchar(255) DEFAULT NULL COMMENT '//只有货主-生产企业，货主-经营企业需要用到该字段',
  `car_info` varchar(255) DEFAULT NULL COMMENT '//我的车辆信息  只有企业车主、个人车主才需要用到该字段',
  `main_business` varchar(255) DEFAULT NULL COMMENT '//主营业务  物流信息公司、国际物流公司、船舶运输、火车运输、航空运输需要用到该字段',
  `qualification` varchar(255) DEFAULT NULL COMMENT '//资质 所有角色都需要用到',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `wechat` varchar(255) DEFAULT NULL COMMENT '微信',
  `qq` varchar(255) DEFAULT NULL COMMENT 'QQ',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hy_user_detail
-- ----------------------------
