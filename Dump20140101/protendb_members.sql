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
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `now` varchar(20) NOT NULL,
  `email` varchar(25) NOT NULL,
  `imageurl` varchar(80) DEFAULT NULL,
  `birth_month` varchar(20) NOT NULL,
  `birth_day` varchar(3) NOT NULL,
  `birth_year` varchar(5) NOT NULL,
  `city` varchar(40) NOT NULL,
  `states` varchar(30) NOT NULL,
  `country` varchar(30) NOT NULL,
  `zipcode` varchar(20) NOT NULL,
  `lat` float(10,6) NOT NULL,
  `lon` float(10,6) NOT NULL,
  `gender` varchar(40) DEFAULT NULL,
  `seeking_a` varchar(40) DEFAULT NULL,
  `looking_for` varchar(40) DEFAULT NULL,
  `aim` varchar(57) DEFAULT NULL,
  `sign` varchar(25) NOT NULL,
  `ethnicity` varchar(20) NOT NULL,
  `height` varchar(15) NOT NULL,
  `hair_color` varchar(15) NOT NULL,
  `body_type` varchar(20) NOT NULL,
  `car` varchar(20) NOT NULL,
  `education` varchar(20) NOT NULL,
  `has_children` varchar(35) NOT NULL,
  `wants_children` varchar(25) NOT NULL,
  `married` varchar(25) NOT NULL,
  `smoker` varchar(25) NOT NULL,
  `drink` varchar(25) NOT NULL,
  `drugs` varchar(25) NOT NULL,
  `religion` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `income` varchar(20) NOT NULL,
  `profession` varchar(17) NOT NULL,
  `headline` varchar(40) NOT NULL,
  `interests` text NOT NULL,
  `searchrankscore` int(11) NOT NULL,
  `percent1` varchar(80) DEFAULT NULL,
  `percent2` varchar(80) DEFAULT NULL,
  `percent3` varchar(80) DEFAULT NULL,
  `points_photos` int(11) DEFAULT NULL,
  `points_profile` int(11) DEFAULT NULL,
  `points_firstmessage` int(11) DEFAULT NULL,
  `points_funny` int(11) DEFAULT NULL,
  `points_interesting` int(11) DEFAULT NULL,
  `points_personality` int(11) DEFAULT NULL,
  `points_firstdate` int(11) DEFAULT NULL,
  `points_dateidea` int(11) DEFAULT NULL,
  `points_verifyprofile` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (95,'lisa','123lisa','offline','lisa@gmail.com','/Cropped/lisa/lisabeaa2a2b-3b39-4e67-8f72-26b71237dbe7.jpg','november','10','1985','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Female','Dating','','','','','','','','','','','','','','','','test','100,001-150,000','','if blah blah blah','test',0,'blah  blah blah','','',0,0,0,0,0,0,0,0,0),(96,'will','123will','offline','will@gmail.com','/Cropped/will/will29cb3d11-a225-4179-b907-3e39f80ef2b6.jpg','october','12','1989','Hampton','GA','United States','30228',33.400002,-84.279999,'Male','Female','Dating','','','','','','','','','','','','','','','','','','','test','',0,'test','','',0,0,0,0,0,0,0,0,0),(97,'deb','123deb','offline','deb@gmail.com','/Cropped/deb/deb21439c7e-b13b-487e-82bf-8140d44e86f2.jpg','november','12','1983','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','test','',0,'yestest','','',0,0,0,0,0,0,0,0,0),(98,'sophia','123sophia','offline','sophia@gmail.com','/Cropped/sophia/sophia426775ac-6eb1-4026-93eb-03642f917d32.jpg','november','11','1985','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Female','Dating','','','Caucasian','','','','','','','','','','','','','','','','test','',0,'yestest','','',0,0,0,0,0,0,0,0,0),(99,'jen','123jen','offline','jen@gmail.com','/Cropped/jen/jen75bb02e1-2a8a-4255-8b36-d435453ec88e.jpg','september','13','1986','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Female','Dating','','','','','','','','','','','Single','','','','','','','teacher','test','',0,'yestest','','',0,0,0,0,0,0,0,0,0),(100,'sara','123sara','offline','sara@gmail.com','/Cropped/sara/nophotosecond.jpeg','october','24','1986','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','test','',0,'yestest','','',0,0,0,0,0,0,0,0,0),(101,'sydney','123sydney','offline','sydnet@gmail.com','/Cropped/sydney/sydney2d71f2be-b1a2-4f53-9621-e57fe887f240.jpg','november','10','1984','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Male','Dating','','','','','','','','','','','','','','','','','','','test','',0,'test','','',0,0,0,0,0,0,0,0,0),(102,'lara','123lara','offline','lara@gmail.com','/Cropped/lara/nophotosecond.jpeg','november','22','1987','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Male','Dating','','','','','','','','','','','','','','','','','','','test','',0,'test','','',0,0,0,0,0,0,0,0,0),(103,'ally','123ally','offline','ally@gmail.com','/Cropped/ally/nophotosecond.jpeg','november','16','1984','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','test','',0,'test','','',0,0,0,0,0,0,0,0,0),(104,'kara','123kara','offline','kara@gmail.com','/Cropped/kara/nophotosecond.jpeg','october','14','1981','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Male','Dating','','','','','','','','','','','','','','','','','','','test','',0,'test','','',0,0,0,0,0,0,0,0,0),(105,'ashley','123ashley','offline','ashley@gmail.com','yes','november','14','1987','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','if blah blah blah','',0,'blah  blah blah','','',0,0,0,0,0,0,0,0,0),(106,'kim','123kim','offline','kim@gmail.com','yes','october','10','1983','Hampton','GA','United States','30228',33.400002,-84.279999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','if blah blah blah','',0,'blah  blah blah','','',0,0,0,0,0,0,0,0,0),(107,'lucy','123lucy','online','lucy@gmail.com','/Cropped/lucy/lucy47490aa9-5c4c-491e-82f2-5787c9ce8236.jpg','november','10','1988','Cumming','GA','United States','30028',34.209999,-84.139999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','you want to ','',0,'you r nuts','','',0,0,0,0,0,0,0,0,0),(108,'bitsy','123bitsy','offline','bitsy@gmail.com','/Cropped/bitsy/nophotosecond.jpeg','november','12','1985','Cumming','GA','United States','30028',34.209999,-84.139999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','you want to','',0,'you r nuts','','',0,0,0,0,0,0,0,0,0),(109,'nadia','123nadia','offline','nadia@gmail.com','/Cropped/nadia/nophotosecond.jpeg','november','12','1989','Cumming','GA','United States','30028',34.209999,-84.139999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','you want to','',0,'you r nuts','','',0,0,0,0,0,0,0,0,0),(110,'kendra','123kendra','offline','kendra@gmail.com','/Cropped/kendra/kendra1efa5d60-75d9-439c-906f-62c6c952443e.jpg','november','22','1987','Cumming','GA','United States','30028',34.209999,-84.139999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','you want to','',0,'you r nuts','','',0,0,0,0,0,0,0,0,0),(111,'taylor','123taylor','offline','taylor@gmail.com','/Cropped/taylor/nophotosecond.jpeg','november','29','1988','Cumming','GA','United States','30028',34.209999,-84.139999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','you want to','',0,'you r nuts','','',0,0,0,0,0,0,0,0,0),(112,'hannah','hannah','offline','hannah@gmail.com','*','october','17','1985','Cumming','GA','United States','30028',34.209999,-84.139999,'Female','Female','Dating','','','','','','','','','','','','','','','','','','','you want to','',0,'you r nuts','','',0,0,0,0,0,0,0,0,0),(113,'chris','123chris','offline','chris@gmail.com','/Cropped/chris/nophotosecond.jpeg','10','16','1974','Sherman Oaks','CA','United States','91423',34.150002,-118.430000,'n/a','Posting items','I am not searching','','','','','','','','','','','','','','','','','','','','',0,'','','',0,0,0,0,0,0,0,0,0),(114,'stan','123stan','offline','stan@gmail.com','/Cropped/stan/nophotosecond.jpeg','10','16','1974','Sherman Oaks','CA','United States','91423',34.150002,-118.430000,'n/a','Both searching and posting','Couch','','','','','','','','','','','','','','','','','','','','',0,'','','',0,0,0,0,0,0,0,0,0),(115,'jan','123jan','offline','jan@gmail.com','/Cropped/jan/nophotosecond.jpeg','10','16','1974','Sherman Oaks','CA','United States','91423',34.150002,-118.430000,'n/a','Searching items','Couch','','','','','','','','','','','','','','','','','','','','',0,'','','',0,0,0,0,0,0,0,0,0),(116,'mike','123mike','offline','mike@gmail.com','/Cropped/mike/nophotosecond.jpeg','10','16','1974','Sherman Oaks','CA','United States','91423',34.150002,-118.430000,'n/a','Searching items','Couch','','','','','','','','','','','','','','','','','','','','',0,'','','',0,0,0,0,0,0,0,0,0),(117,'hank','123hank','offline','hank@gmail.com','/Cropped/hank/nophotosecond.jpeg','10','16','1974','Sherman Oaks','CA','United States','91423',34.150002,-118.430000,'n/a','Posting items','I am not searching','','','','','','','','','','','','','','','','','','','','',0,'','','',0,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
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
