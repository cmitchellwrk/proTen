CREATE DATABASE  IF NOT EXISTS `protendb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `protendb`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: protendb
-- ------------------------------------------------------
-- Server version	5.5.9

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mailsettings`
--

DROP TABLE IF EXISTS `mailsettings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mailsettings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idmember` bigint(20) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `firstcontactmessgesize` varchar(30) NOT NULL,
  `agefrom` varchar(3) DEFAULT NULL,
  `ageto` varchar(3) DEFAULT NULL,
  `within` varchar(15) NOT NULL,
  `hangout` tinyint(1) NOT NULL,
  `friendship` tinyint(1) NOT NULL,
  `activitypartner` tinyint(1) NOT NULL,
  `dating` tinyint(1) NOT NULL,
  `longterm` tinyint(1) NOT NULL,
  `intimateencounter` tinyint(1) NOT NULL,
  `talkemail` tinyint(1) NOT NULL,
  `otherrelationship` tinyint(1) NOT NULL,
  `usedrugs` tinyint(1) NOT NULL,
  `smoke` tinyint(1) NOT NULL,
  `havemessagedintenct` tinyint(1) NOT NULL,
  `emailaddress` varchar(30) NOT NULL,
  `email1` tinyint(1) NOT NULL,
  `email2` tinyint(1) NOT NULL,
  `email3` tinyint(1) NOT NULL,
  `email4` tinyint(1) NOT NULL,
  `email5` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mailsettings`
--

LOCK TABLES `mailsettings` WRITE;
/*!40000 ALTER TABLE `mailsettings` DISABLE KEYS */;
INSERT INTO `mailsettings` VALUES (74,95,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(75,96,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(76,97,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(77,98,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(78,99,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(79,100,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(80,101,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(81,102,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(82,103,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(83,104,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(84,105,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(85,106,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(86,107,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(87,108,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(88,109,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(89,110,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(90,111,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(91,112,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(92,113,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(93,114,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(94,115,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(95,116,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0),(96,117,'Either','United States','Any size','18','99','Any',0,0,0,0,0,0,0,0,0,0,0,'xyzxyz@gmail.com',0,0,0,0,0);
/*!40000 ALTER TABLE `mailsettings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-01 15:07:35
