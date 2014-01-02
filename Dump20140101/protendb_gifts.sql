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
-- Table structure for table `gifts`
--

DROP TABLE IF EXISTS `gifts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gifts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idmember` bigint(20) NOT NULL,
  `giftone` varchar(30) NOT NULL,
  `gifttwo` varchar(30) NOT NULL,
  `giftthree` varchar(30) NOT NULL,
  `giftfour` varchar(30) NOT NULL,
  `giftfive` varchar(30) NOT NULL,
  `giftsix` varchar(30) NOT NULL,
  `giftseven` varchar(30) NOT NULL,
  `gifteight` varchar(30) NOT NULL,
  `giftnine` varchar(30) NOT NULL,
  `giftten` varchar(30) NOT NULL,
  `gifteleven` varchar(30) NOT NULL,
  `gifttwelve` varchar(30) NOT NULL,
  `giftthirteen` varchar(30) NOT NULL,
  `giftfourteen` varchar(30) NOT NULL,
  `giftfifteen` varchar(30) NOT NULL,
  `giftsixteen` varchar(30) NOT NULL,
  `giftseventeen` varchar(30) NOT NULL,
  `giftseighteen` varchar(30) NOT NULL,
  `giftsnineteen` varchar(30) NOT NULL,
  `giftstwenty` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gifts`
--

LOCK TABLES `gifts` WRITE;
/*!40000 ALTER TABLE `gifts` DISABLE KEYS */;
/*!40000 ALTER TABLE `gifts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-01 15:07:37
