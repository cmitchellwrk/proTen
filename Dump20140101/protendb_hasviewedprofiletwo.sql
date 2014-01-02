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
-- Table structure for table `hasviewedprofiletwo`
--

DROP TABLE IF EXISTS `hasviewedprofiletwo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hasviewedprofiletwo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idcurrent` bigint(20) NOT NULL,
  `idhvperson` bigint(20) NOT NULL,
  `username` varchar(30) NOT NULL,
  `now` varchar(20) NOT NULL,
  `imageurl` varchar(80) DEFAULT NULL,
  `city` varchar(40) NOT NULL,
  `dateandtime` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hasviewedprofiletwo`
--

LOCK TABLES `hasviewedprofiletwo` WRITE;
/*!40000 ALTER TABLE `hasviewedprofiletwo` DISABLE KEYS */;
INSERT INTO `hasviewedprofiletwo` VALUES (5,95,94,'apple','online','/Cropped/apple/nophotosecond.jpeg','Hampton',' 03/31/2013 01:49:19 AM PDT'),(6,99,95,'lisa','offline','/Cropped/lisa/lisabeaa2a2b-3b39-4e67-8f72-26b71237dbe7.jpg','Hampton',' 03/31/2013 04:32:07 PM PDT'),(7,100,95,'lisa','offline','/Cropped/lisa/lisabeaa2a2b-3b39-4e67-8f72-26b71237dbe7.jpg','Hampton',' 06/02/2013 12:00:29 PM PDT'),(8,97,107,'lucy','online','/Cropped/lucy/lucy47490aa9-5c4c-491e-82f2-5787c9ce8236.jpg','Cumming',' 06/02/2013 10:19:23 PM PDT'),(10,107,99,'jen','offline','/Cropped/jen/jen75bb02e1-2a8a-4255-8b36-d435453ec88e.jpg','Hampton',' 06/03/2013 07:54:01 PM PDT'),(11,98,107,'lucy','online','/Cropped/lucy/lucy47490aa9-5c4c-491e-82f2-5787c9ce8236.jpg','Cumming',' 06/03/2013 08:22:46 PM PDT');
/*!40000 ALTER TABLE `hasviewedprofiletwo` ENABLE KEYS */;
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
