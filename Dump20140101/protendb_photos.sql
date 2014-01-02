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
-- Table structure for table `photos`
--

DROP TABLE IF EXISTS `photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photos` (
  `photouserid` bigint(20) NOT NULL,
  `imageurl1a` varchar(80) DEFAULT NULL,
  `imageurl1b` varchar(80) DEFAULT NULL,
  `imageurl2a` varchar(80) DEFAULT NULL,
  `imageurl2b` varchar(80) DEFAULT NULL,
  `imageurl3a` varchar(80) DEFAULT NULL,
  `imageurl3b` varchar(80) DEFAULT NULL,
  `imageurl4a` varchar(80) DEFAULT NULL,
  `imageurl4b` varchar(80) DEFAULT NULL,
  `imageurl5a` varchar(80) DEFAULT NULL,
  `imageurl5b` varchar(80) DEFAULT NULL,
  `imageurl6a` varchar(80) DEFAULT NULL,
  `imageurl6b` varchar(80) DEFAULT NULL,
  `imageurl7a` varchar(80) DEFAULT NULL,
  `imageurl7b` varchar(80) DEFAULT NULL,
  `imageurl8a` varchar(80) DEFAULT NULL,
  `imageurl8b` varchar(80) DEFAULT NULL,
  `imageurl9a` varchar(50) NOT NULL,
  `imageurl9b` varchar(50) NOT NULL,
  `imageurl10a` varchar(50) NOT NULL,
  `imageurl10b` varchar(50) NOT NULL,
  `imageurl11a` varchar(50) NOT NULL,
  `imageurl11b` varchar(50) NOT NULL,
  `imageurl12a` varchar(50) NOT NULL,
  `imageurl12b` varchar(50) NOT NULL,
  `imageurl13a` varchar(50) NOT NULL,
  `imageurl13b` varchar(50) NOT NULL,
  `imageurl14a` varchar(50) NOT NULL,
  `imageurl14b` varchar(50) NOT NULL,
  `imageurl15a` varchar(50) NOT NULL,
  `imageurl15b` varchar(50) NOT NULL,
  `imageurl16a` varchar(50) NOT NULL,
  `imageurl16b` varchar(50) NOT NULL,
  PRIMARY KEY (`photouserid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photos`
--

LOCK TABLES `photos` WRITE;
/*!40000 ALTER TABLE `photos` DISABLE KEYS */;
INSERT INTO `photos` VALUES (95,'/Cropped/lisa/lisabeaa2a2b-3b39-4e67-8f72-26b71237dbe7.jpg','/Cropped/lisa/lisabeaa2a2b-3b39-4e67-8f72-26b71237dbe7s.jpg','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(96,'/Cropped/will/will29cb3d11-a225-4179-b907-3e39f80ef2b6.jpg','/Cropped/will/will29cb3d11-a225-4179-b907-3e39f80ef2b6s.jpg','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(97,'/Cropped/deb/deb21439c7e-b13b-487e-82bf-8140d44e86f2.jpg','/Cropped/deb/deb21439c7e-b13b-487e-82bf-8140d44e86f2s.jpg','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(98,'/Cropped/sophia/sophia426775ac-6eb1-4026-93eb-03642f917d32.jpg','/Cropped/sophia/sophia426775ac-6eb1-4026-93eb-03642f917d32s.jpg','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(99,'/Cropped/jen/jen75bb02e1-2a8a-4255-8b36-d435453ec88e.jpg','/Cropped/jen/jen75bb02e1-2a8a-4255-8b36-d435453ec88es.jpg','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(100,'/Cropped/sara/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(101,'/Cropped/sydney/sydney2d71f2be-b1a2-4f53-9621-e57fe887f240.jpg','/Cropped/sydney/sydney2d71f2be-b1a2-4f53-9621-e57fe887f240s.jpg','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(102,'/Cropped/lara/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(103,'/Cropped/ally/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(104,'/Cropped/kara/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(105,'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(106,'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(107,'/Cropped/lucy/lucy47490aa9-5c4c-491e-82f2-5787c9ce8236.jpg','/Cropped/lucy/lucy47490aa9-5c4c-491e-82f2-5787c9ce8236s.jpg','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(108,'/Cropped/bitsy/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(109,'/Cropped/nadia/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(110,'/Cropped/kendra/kendra1efa5d60-75d9-439c-906f-62c6c952443e.jpg','/Cropped/kendra/kendra1efa5d60-75d9-439c-906f-62c6c952443es.jpg','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(111,'/Cropped/taylor/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(112,'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(113,'/Cropped/chris/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(114,'/Cropped/stan/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(115,'/Cropped/jan/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(116,'/Cropped/mike/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'),(117,'/Cropped/hank/nophotosecond.jpeg','*','#','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*');
/*!40000 ALTER TABLE `photos` ENABLE KEYS */;
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
