/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-06 23:54:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `authorID` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(50) DEFAULT NULL,
  `lName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`authorID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('1', 'جلال', 'آل احمد');
INSERT INTO `author` VALUES ('2', 'محمود', 'دولت آبادی');
INSERT INTO `author` VALUES ('3', 'فاضل', 'نظری');
INSERT INTO `author` VALUES ('4', 'صادق', 'هدایت');
INSERT INTO `author` VALUES ('5', 'ویکتور', 'هوگو');
INSERT INTO `author` VALUES ('6', 'آندره', 'ژید');
INSERT INTO `author` VALUES ('7', 'عبدالحسین', 'زرین کوب');
INSERT INTO `author` VALUES ('8', 'علی', 'شریعتی');
INSERT INTO `author` VALUES ('9', 'مرتضی', 'مطهری');
INSERT INTO `author` VALUES ('10', 'علی محمد', 'افغانی');
INSERT INTO `author` VALUES ('11', 'اقبال', 'لاهوری');
INSERT INTO `author` VALUES ('12', 'جبرا', 'ابراهیم جبرا');
INSERT INTO `author` VALUES ('13', 'محمود', 'درویش');
INSERT INTO `author` VALUES ('14', 'مهدی', 'اخوان ثالث');
INSERT INTO `author` VALUES ('15', 'احمد', 'شاملو');
INSERT INTO `author` VALUES ('16', 'فروغ', 'فرخزاد');
INSERT INTO `author` VALUES ('17', 'روح الله', 'خمینی');
INSERT INTO `author` VALUES ('18', 'نیما', 'یوشیج');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `authorID` int(11) NOT NULL,
  `translatorID` varchar(200) DEFAULT NULL,
  `categoryID` int(11) NOT NULL,
  `publishedYear` year(4) DEFAULT NULL,
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'دیدوبازدید', '1', null, '5', '1945');
INSERT INTO `book` VALUES ('2', 'مائده های زمینی', '6', '1', '2', '1955');
INSERT INTO `book` VALUES ('3', 'زن زیادی', '1', null, '1', '1952');
INSERT INTO `book` VALUES ('4', 'رباعیات خبام', '4', null, '6', '1923');
INSERT INTO `book` VALUES ('5', 'بوف کور', '4', null, '5', '1936');
INSERT INTO `book` VALUES ('6', 'بینوایان', '5', '2', '5', '1901');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'طنز');
INSERT INTO `category` VALUES ('2', 'رمانتیک');
INSERT INTO `category` VALUES ('3', 'علمی');
INSERT INTO `category` VALUES ('4', 'ترسناک');
INSERT INTO `category` VALUES ('5', 'اجتماعی');
INSERT INTO `category` VALUES ('6', 'ادبی');

-- ----------------------------
-- Table structure for translator
-- ----------------------------
DROP TABLE IF EXISTS `translator`;
CREATE TABLE `translator` (
  `translatorID` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(50) DEFAULT NULL,
  `lName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`translatorID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of translator
-- ----------------------------
INSERT INTO `translator` VALUES ('1', 'جلال', 'آل احمد');
INSERT INTO `translator` VALUES ('2', 'محسن', 'سلیمانی');
