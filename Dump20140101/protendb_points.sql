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
-- Table structure for table `points`
--

DROP TABLE IF EXISTS `points`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `points` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idpersonpointsreceive` bigint(20) NOT NULL,
  `points_photos` int(11) DEFAULT NULL,
  `points_profile` int(11) DEFAULT NULL,
  `points_firstmessage` int(11) DEFAULT NULL,
  `points_funny` int(11) DEFAULT NULL,
  `points_interesting` int(11) DEFAULT NULL,
  `points_personality` int(11) DEFAULT NULL,
  `points_firstdate` int(11) DEFAULT NULL,
  `points_dateidea` int(11) DEFAULT NULL,
  `points_verifyprofile` int(11) DEFAULT NULL,
  `badge` varchar(50) DEFAULT NULL,
  `badgeimageurl` varchar(70) DEFAULT NULL,
  `totalscore` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `points`
--

LOCK TABLES `points` WRITE;
/*!40000 ALTER TABLE `points` DISABLE KEYS */;
INSERT INTO `points` VALUES (7,80,0,0,0,0,0,0,0,0,0,'none','none',0),(22,95,0,0,0,0,0,0,0,0,0,'none','none',0),(23,96,0,0,0,0,0,0,0,0,0,'none','none',0),(24,97,0,0,0,0,0,0,0,0,0,'none','none',0),(25,98,0,0,0,0,0,0,0,0,0,'none','none',0),(26,99,0,0,0,0,0,0,0,0,0,'none','none',0),(27,100,0,0,0,0,0,0,0,0,0,'none','none',0),(28,101,0,0,0,0,0,0,0,0,0,'none','none',0),(29,102,0,0,0,0,0,0,0,0,0,'none','none',0),(30,103,0,0,0,0,0,0,0,0,0,'none','none',0),(31,104,0,0,0,0,0,0,0,0,0,'none','none',0),(32,105,0,0,0,0,0,0,0,0,0,'none','none',0),(33,106,0,0,0,0,0,0,0,0,0,'none','none',0),(34,107,0,0,0,0,0,0,0,0,0,'none','none',0),(35,108,0,0,0,0,0,0,0,0,0,'none','none',0),(36,109,0,0,0,0,0,0,0,0,0,'none','none',0),(37,110,0,0,0,0,0,0,0,0,0,'none','none',0),(38,111,0,0,0,0,0,0,0,0,0,'none','none',0),(39,112,0,0,0,0,0,0,0,0,0,'none','none',0),(40,113,0,0,0,0,0,0,0,0,0,'none','none',0),(41,114,0,0,0,0,0,0,0,0,0,'none','none',0),(42,115,0,0,0,0,0,0,0,0,0,'none','none',0),(43,116,0,0,0,0,0,0,0,0,0,'none','none',0),(44,117,0,0,0,0,0,0,0,0,0,'none','none',0);
/*!40000 ALTER TABLE `points` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-01 15:07:38
