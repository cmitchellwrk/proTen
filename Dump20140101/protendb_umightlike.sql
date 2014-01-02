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
-- Table structure for table `umightlike`
--

DROP TABLE IF EXISTS `umightlike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `umightlike` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idcurrent` bigint(20) NOT NULL,
  `idfavperson` bigint(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `now` varchar(20) NOT NULL,
  `imageurl` varchar(30) NOT NULL,
  `city` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `umightlike`
--

LOCK TABLES `umightlike` WRITE;
/*!40000 ALTER TABLE `umightlike` DISABLE KEYS */;
INSERT INTO `umightlike` VALUES (4,95,94,'111','online','111','111'),(5,95,94,'111','online','111','111'),(7,95,99,'111','offline','111','111'),(8,95,99,'111','offline','111','111'),(9,95,99,'111','offline','111','111'),(10,95,99,'111','offline','111','111'),(11,95,99,'111','offline','111','111'),(12,95,99,'111','offline','111','111'),(13,95,99,'111','offline','111','111'),(14,95,99,'111','offline','111','111'),(15,95,99,'111','offline','111','111'),(16,95,99,'111','offline','111','111'),(17,95,99,'111','offline','111','111'),(18,95,99,'111','offline','111','111'),(19,95,99,'111','offline','111','111'),(20,95,99,'111','offline','111','111'),(21,95,99,'111','offline','111','111'),(22,95,99,'111','offline','111','111'),(23,95,99,'111','offline','111','111'),(24,95,99,'111','offline','111','111'),(25,95,99,'111','offline','111','111'),(26,95,99,'111','offline','111','111'),(27,95,100,'111','offline','111','111'),(28,95,100,'111','offline','111','111'),(29,95,100,'111','offline','111','111'),(30,95,100,'111','offline','111','111'),(31,107,97,'111','offline','111','111'),(32,107,94,'111','online','111','111'),(33,99,107,'111','online','111','111'),(34,107,98,'111','offline','111','111');
/*!40000 ALTER TABLE `umightlike` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-01 15:07:36
