CREATE DATABASE  IF NOT EXISTS `demoapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `demoapp`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: demoapp
-- ------------------------------------------------------
-- Server version	5.5.40-log

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
-- Table structure for table `doctransitioninfo`
--

DROP TABLE IF EXISTS `doctransitioninfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctransitioninfo` (
  `transitionID` int(11) NOT NULL AUTO_INCREMENT,
  `bodyAttributes` varchar(255) DEFAULT NULL,
  `languageCode` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `docIdf` int(11) DEFAULT NULL,
  PRIMARY KEY (`transitionID`),
  KEY `FK_8ad1ms7cid95oj3ltfnoi10sm` (`docIdf`),
  CONSTRAINT `FK_8ad1ms7cid95oj3ltfnoi10sm` FOREIGN KEY (`docIdf`) REFERENCES `document` (`docID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctransitioninfo`
--

LOCK TABLES `doctransitioninfo` WRITE;
/*!40000 ALTER TABLE `doctransitioninfo` DISABLE KEYS */;
INSERT INTO `doctransitioninfo` VALUES (1,'szdczd','en','xcvdfvdx',1),(2,'dvsvd','sdvfs','sdcfs',1),(3,'nh','en','jghgjg',1),(4,'nh','en','jghgjg',NULL),(5,NULL,NULL,NULL,NULL),(6,NULL,NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL),(8,'jdh cjdsc bhsdjxvd','en','sdjkv',NULL),(9,'jdh cjdsc bhsdjxvd','en','sdjkv',NULL),(10,'jdh cjdsc bhsdjxvd','en','sdjkv',NULL),(11,'jdh cjdsc bhsdjxvd','en','sdjkv',NULL),(12,'c xd','en','dvd',NULL),(13,'jdsv d','en','sdjkv',NULL),(14,'jdsv d','en','sdjkv',NULL),(15,'jdsv d','en','sdjkv',NULL),(16,'jdsv d','en','sdjkv',NULL),(17,'jdsv d','en','sdjkv',NULL),(18,'jdsv d','en','sdjkv',NULL),(19,'adfadsfasdf d','en','manish',NULL),(20,'adfad s','en','manish',24),(21,'adfad s','en','manish',25),(22,'c xd','en','dvd',NULL),(23,'c xd','en','dvd',NULL),(24,'akki','en','dvd',NULL),(25,'akki','en','dvd',NULL),(26,'akki','en','dvd',NULL),(27,'akki','en','dvd',22),(28,'akki','en','dvd',22),(29,'adfad s','en','manish',26),(30,'adfad s','en','smit',27),(31,'akki','en','dvd',22);
/*!40000 ALTER TABLE `doctransitioninfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `docID` int(11) NOT NULL AUTO_INCREMENT,
  `createdDate` datetime DEFAULT NULL,
  `tagAttributes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`docID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (1,'2015-05-04 16:53:34','ddvdfvdxv'),(2,'2016-04-06 14:03:19','kh'),(3,'2016-04-06 14:05:19','kh'),(4,'2016-04-06 15:16:47',NULL),(5,'2016-04-06 15:17:41',NULL),(6,'2016-04-06 15:19:17',NULL),(7,'2016-04-06 15:32:12',NULL),(8,'2016-04-06 15:35:29','kh'),(9,'2016-04-06 15:37:18','kh'),(10,'2016-04-06 15:38:10',NULL),(11,'2016-04-06 15:38:25',NULL),(12,'2016-04-06 15:40:31',NULL),(13,'2016-04-06 15:42:09','java'),(14,'2016-04-06 15:59:48','java'),(15,'2016-04-06 16:09:59','java,j2EE'),(16,'2016-04-06 17:01:08','java,j2EE'),(17,'2016-04-06 17:20:35','java,Spring'),(18,'2016-04-06 17:23:35','java,Spring'),(19,'2016-04-06 17:25:01','java,Spring'),(20,'2016-04-06 17:42:46','java,Spring'),(21,'2016-04-06 17:45:48','java,Spring'),(22,'2016-04-06 17:58:34','java,Spring'),(23,'2016-04-06 18:04:21','java,Spring'),(24,'2016-04-06 18:12:32','java,Spring'),(25,'2016-04-06 18:14:10','java,Spring'),(26,'2016-04-06 18:52:31','java,Spring'),(27,'2016-04-06 18:53:51','java,Spring,j2ee');
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userIdp` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(80) NOT NULL,
  `userName` varchar(80) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userIdp`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'abc@gmail.com','abc','12345','Manager'),(2,'test','test','12345','User');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(80) NOT NULL,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-06 20:29:54
