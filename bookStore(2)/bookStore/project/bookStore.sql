/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.14 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bookID` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) DEFAULT NULL,
  `authorName` varchar(255) DEFAULT NULL,
  `ISBN` bigint(20) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `pages` bigint(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `sailBook` bigint(20) DEFAULT NULL,
  `pubAddress` varchar(255) DEFAULT NULL,
  `pubEmail` varchar(255) DEFAULT NULL,
  `pubPhone` int(11) DEFAULT NULL,
  `pubBank` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookID`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bookID`,`bookName`,`authorName`,`ISBN`,`genre`,`publisher`,`pages`,`price`,`number`,`sailBook`,`pubAddress`,`pubEmail`,`pubPhone`,`pubBank`) values 
(1,'prince','mark',11,'novel','aie',12,10,14,11,'america','123456',123123,1111),
(2,'two','author2',12,'gener2','publisher1',50,20,20,10,'ad2','1234567',123123,2222),
(3,'three','author3',13,'gener3','publisher2',30,30,30,5,'ad3','12345678',123456,3333),
(4,'four','author4',14,'gener','publish',40,40,40,5,'ad4','12345678',1234567,4444),
(5,'five','author5',15,'gener','publish',20,50,50,0,'ad5','1234567',12345678,5555);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`id`,`userName`,`password`) values 
(1,'admin','123456');

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `orderId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `bookId` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `orderDate` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`orderId`,`userId`,`bookId`,`num`,`orderDate`,`location`,`price`) values 
(1,1,'1','2','2020-03-25 19:10:04','w',18),
(2,1,'2','2','2020-03-25 21:11:11','w',12),
(3,1,'2','2','2020-03-25 21:11:30','w',12);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`password`) values 
(1,'jack','123456'),
(2,'admin','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
