/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云MySQL数据库
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-bp1eb34u9vk19ll3vao.mysql.rds.aliyuncs.com:3306
 Source Schema         : xinguan

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/12/2021 03:21:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for instock
-- ----------------------------
DROP TABLE IF EXISTS `instock`;
CREATE TABLE `instock`  (
  `instock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库单号',
  `createtime` datetime(0) NOT NULL COMMENT '入库单创建时间',
  `donor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '匿名' COMMENT '捐赠人',
  `donation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '捐赠物',
  `in_num` int(11) NULL DEFAULT NULL COMMENT '捐赠数量',
  PRIMARY KEY (`instock_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of instock
-- ----------------------------
INSERT INTO `instock` VALUES (24, '2021-12-17 03:06:57', '王力宏', '呼吸机', 5);
INSERT INTO `instock` VALUES (25, '2021-12-17 03:07:16', '马云', '口罩', 100000);
INSERT INTO `instock` VALUES (26, '2021-12-17 03:07:43', '周杰伦', '防护服', 35);
INSERT INTO `instock` VALUES (27, '2021-12-17 03:07:59', '周杰伦', '呼吸机', 5);
INSERT INTO `instock` VALUES (28, '2021-12-17 03:09:51', '特朗普', '美元', 100);
INSERT INTO `instock` VALUES (29, '2021-12-17 03:10:13', '比尔盖茨', '呼吸机', 1000);

-- ----------------------------
-- Table structure for outstock
-- ----------------------------
DROP TABLE IF EXISTS `outstock`;
CREATE TABLE `outstock`  (
  `outstock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库单号',
  `createtime` datetime(0) NOT NULL COMMENT '出库时间',
  `thing` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库物品',
  `out_num` int(11) NULL DEFAULT NULL COMMENT '出库物品数量',
  `for_who` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '受捐助者',
  PRIMARY KEY (`outstock_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of outstock
-- ----------------------------
INSERT INTO `outstock` VALUES (1, '2021-12-17 03:08:44', '呼吸机', 6, '中国');
INSERT INTO `outstock` VALUES (2, '2021-12-17 03:09:10', '口罩', 9000, '美国纽约');
INSERT INTO `outstock` VALUES (3, '2021-12-17 03:11:02', '防护服', 35, '俄罗斯');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物品ID',
  `thing_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品名',
  `thing_num` int(11) NOT NULL DEFAULT 0 COMMENT '物品数量',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`stock_id`) USING BTREE,
  UNIQUE INDEX `stock_thing_name_uindex`(`thing_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (16, '呼吸机', 1004, '2021-12-17 03:10:14');
INSERT INTO `stock` VALUES (17, '口罩', 91000, '2021-12-17 03:09:10');
INSERT INTO `stock` VALUES (18, '防护服', 0, '2021-12-17 03:11:02');
INSERT INTO `stock` VALUES (19, '美元', 100, '2021-12-17 03:09:52');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '华杉', '华杉');

SET FOREIGN_KEY_CHECKS = 1;
