/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : jdbc

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-03-28 20:06:41
*/
drop database if exists jdbc;

/*==============================================================*/
/* Database: jdbc                                               */
/*==============================================================*/
create database jdbc;

use jdbc;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jdbc
-- ----------------------------
DROP TABLE IF EXISTS `jdbc`;
CREATE TABLE `jdbc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
