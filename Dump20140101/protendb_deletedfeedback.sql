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
-- Table structure for table `deletedfeedback`
--

DROP TABLE IF EXISTS `deletedfeedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deletedfeedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `usernamedelete` varchar(40) NOT NULL,
  `passworddelete` varchar(40) NOT NULL,
  `reasonfordelete` varchar(80) NOT NULL,
  `howmanydates` varchar(3) NOT NULL,
  `suggestions` text NOT NULL,
  `recommendation` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deletedfeedback`
--

LOCK TABLES `deletedfeedback` WRITE;
/*!40000 ALTER TABLE `deletedfeedback` DISABLE KEYS */;
INSERT INTO `deletedfeedback` VALUES (1,'lisa','123lisa','I\'d rather use another site','4','no','no'),(2,'lisa','123lisa','Didn\'t find anyone I liked.','4','fytftd','no'),(3,'lisa','123lisa','I found someon on Chemispark','4','v hgcfty','no'),(4,'lisa','123lisa','I\'d rather use another site','4','dcgfdx','yes'),(5,'lisa','123lisa','Found someone offline','6','jnhtnd','no'),(6,'ally','123ally','Didn\'t find anyone I liked.','4','test','yes'),(7,'lisa','123lisa','Found someone on another site','6','test','no'),(8,'amy','123amy','Too many jerks, rude and/or mean people','6','test','no'),(9,'amy','123amy','Found someone offline','7','rfytf','yes'),(10,'lisa','123lisa','Found someone on another site','4','vuviv','no'),(11,'amanda','123amanda','I found someon on Chemispark','4','bfdbdfb','no'),(12,'ashley','123ashley','Too many jerks, rude and/or mean people','5','guygtyf','no'),(13,'alex','123alex','Found someone on another site','6','hiugyg','no'),(14,'apple','123apple','Found someone on another site','4','t65etf','no'),(15,'chris','123chris','Didn\'t find anyone I liked.','2','tesrt','yes'),(16,'stan','123stan','I\'d rather use another site','2','test','yes'),(17,'apple','123apple','Didn\'t find anyone I liked.','1','none','yes');
/*!40000 ALTER TABLE `deletedfeedback` ENABLE KEYS */;
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
