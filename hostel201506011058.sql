-- MySQL dump 10.13  Distrib 5.5.30, for Win32 (x86)
--
-- Host: localhost    Database: hostel
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Current Database: `hostel`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hostel` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hostel`;

--
-- Table structure for table `admin`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `admin` (
  `name` varchar(10) DEFAULT NULL,
  `pass` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`name`, `pass`) VALUES ('nabeel','nabeel');

--
-- Table structure for table `hostel_room`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `hostel_room` (
  `room` int(5) DEFAULT NULL,
  `capacity` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hostel_room`
--

INSERT INTO `hostel_room` (`room`, `capacity`) VALUES (1,1),(2,2),(3,3),(5,2),(6,3),(7,1),(8,1),(9,2),(10,3),(11,2),(13,1),(14,3),(15,2);

--
-- Table structure for table `student`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS `student` (
  `r_no` varchar(12) DEFAULT NULL,
  `year` varchar(4) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `branch` varchar(12) DEFAULT NULL,
  `room` varchar(10) DEFAULT NULL,
  `r_ment` int(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`r_no`, `year`, `name`, `branch`, `room`, `r_ment`) VALUES ('37','1','nabeeel37','it','3',3),('38','2','nabeeel38','it','1',1),('39','3','nabeeel39','it','2',2),('40','4','nabeeel40','it','6',3),('41','1','nabeeel41','it','3',3),('42','2','nabeeel42','it','7',1),('43','3','nabeeel43','it','2',2),('44','4','nabeeel44','it','6',3),('45','1','nabeeel45','it','3',3),('46','2','nabeeel46','it','8',1),('47','3','nabeeel47','it','5',2),('48','4','nabeeel48','it','6',3),('49','1','nabeeel49','it','10',3),('50','2','nabeeel50','it','13',1),('51','3','nabeeel51','it','5',2),('52','4','nabeeel52','it','14',3),('53','1','nabeeel53','it','10',3),('54','2','nabeeel54','it','0',1),('55','3','nabeeel55','it','9',2),('56','4','nabeeel56','it','14',3),('57','1','nabeeel57','it','10',3),('58','2','nabeeel58','it','0',1),('59','3','nabeeel59','it','9',2),('60','4','nabeeel60','it','14',3);
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-01 10:58:18
