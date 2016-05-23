/*
Navicat MySQL Data Transfer

Source Server         : centOs
Source Server Version : 50627
Source Host           : 139.129.25.229:3306
Source Database       : training

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-05-15 13:06:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `right_result` int(255) NOT NULL DEFAULT '0',
  `total_cnt` int(255) NOT NULL DEFAULT '0',
  `grade_cnt` int(255) NOT NULL DEFAULT '0',
  `mark` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `total` int(255) NOT NULL DEFAULT '0',
  `right_result` int(255) NOT NULL DEFAULT '0',
  `wrong_result` int(255) NOT NULL DEFAULT '0',
  `costtime` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for typing
-- ----------------------------
DROP TABLE IF EXISTS `typing`;
CREATE TABLE `typing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `play_cnt` int(255) NOT NULL DEFAULT '0',
  `play_index` int(255) NOT NULL DEFAULT '0',
  `result` int(255) NOT NULL DEFAULT '0' COMMENT '1 means true',
  `reason` int(255) NOT NULL DEFAULT '0' COMMENT '0 true,1 false, 2 timeout',
  `cost` int(255) NOT NULL DEFAULT '0' COMMENT 'cost time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `mobile` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `sex` varchar(255) NOT NULL DEFAULT '',
  `age` int(11) NOT NULL DEFAULT '0',
  `address` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for voice
-- ----------------------------
DROP TABLE IF EXISTS `voice`;
CREATE TABLE `voice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `play_cnt` int(255) NOT NULL DEFAULT '0',
  `play_index` int(255) NOT NULL DEFAULT '0',
  `result` int(255) NOT NULL DEFAULT '0' COMMENT '1 means true',
  `reason` int(255) NOT NULL DEFAULT '0' COMMENT '0 true,1 false, 2 timeout',
  `try_time` int(11) NOT NULL DEFAULT '0' COMMENT 'try time',
  `cost` int(255) NOT NULL DEFAULT '0' COMMENT 'cost time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8;
