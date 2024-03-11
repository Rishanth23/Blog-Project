/*
SQLyog Community v8.71 
MySQL - 5.5.30 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `blog`;

/*Table structure for table `blogdata` */

DROP TABLE IF EXISTS `blogdata`;

CREATE TABLE `blogdata` (
  `Bid` int(11) NOT NULL AUTO_INCREMENT,
  `Uid` varchar(255) DEFAULT NULL,
  `bdata` varchar(5000) DEFAULT NULL,
  `Date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Bid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `blogdata` */

insert  into `blogdata`(`Bid`,`Uid`,`bdata`,`Date`) values (3,'abc@gmail.com','Wikipedia is a free online encyclopedia, created and edited by volunteers around the world and hosted by the Wikimedia Foundation.','Thu Nov 17 12:16:01 IST 2022'),(4,'Mir@gmail.com','sdfghjhgfds','Thu Nov 17 12:16:01 IST 2022'),(5,'abc@gmail.com','What is Arts ?','Thu Nov 17 12:16:01 IST 2022');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `FirstName` varchar(255) DEFAULT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`FirstName`,`Email`,`Password`) values ('Sam','abc@gmail.com','1234'),('Mir','Mir@gmail.com','1234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
