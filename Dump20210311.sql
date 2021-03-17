-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cakeshop
-- ------------------------------------------------------
-- Server version	5.7.33-log

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
-- Table structure for table `addresstable`
--

DROP TABLE IF EXISTS `addresstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresstable` (
  `addressid` int(11) NOT NULL AUTO_INCREMENT,
  `housenumber` int(11) NOT NULL,
  `streetname` varchar(100) NOT NULL,
  `suburb` varchar(100) DEFAULT NULL,
  `city` varchar(100) NOT NULL,
  `postcode` int(11) NOT NULL,
  PRIMARY KEY (`addressid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresstable`
--

LOCK TABLES `addresstable` WRITE;
/*!40000 ALTER TABLE `addresstable` DISABLE KEYS */;
/*!40000 ALTER TABLE `addresstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carttable`
--

DROP TABLE IF EXISTS `carttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carttable` (
  `cartid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`cartid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carttable`
--

LOCK TABLES `carttable` WRITE;
/*!40000 ALTER TABLE `carttable` DISABLE KEYS */;
/*!40000 ALTER TABLE `carttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorytable`
--

DROP TABLE IF EXISTS `categorytable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorytable` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(100) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorytable`
--

LOCK TABLES `categorytable` WRITE;
/*!40000 ALTER TABLE `categorytable` DISABLE KEYS */;
INSERT INTO `categorytable` VALUES (1,'Pringles','ACTIVE'),(2,'Doughnuts','ACTIVE');
/*!40000 ALTER TABLE `categorytable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customertable`
--

DROP TABLE IF EXISTS `customertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customertable` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telephonehome` varchar(10) DEFAULT NULL,
  `telephonemobile` varchar(10) NOT NULL,
  `id` varchar(13) NOT NULL,
  `addressid` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`customerid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customertable`
--

LOCK TABLES `customertable` WRITE;
/*!40000 ALTER TABLE `customertable` DISABLE KEYS */;
/*!40000 ALTER TABLE `customertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredienttable`
--

DROP TABLE IF EXISTS `ingredienttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredienttable` (
  `ingredientid` int(11) NOT NULL AUTO_INCREMENT,
  `ingredientname` varchar(100) NOT NULL,
  `quantity` int(10) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`ingredientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredienttable`
--

LOCK TABLES `ingredienttable` WRITE;
/*!40000 ALTER TABLE `ingredienttable` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredienttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetailstable`
--

DROP TABLE IF EXISTS `orderdetailstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetailstable` (
  `orderdetailsid` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `productprice` double NOT NULL,
  `orderdate` date NOT NULL,
  PRIMARY KEY (`orderdetailsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetailstable`
--

LOCK TABLES `orderdetailstable` WRITE;
/*!40000 ALTER TABLE `orderdetailstable` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetailstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderstable`
--

DROP TABLE IF EXISTS `orderstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderstable` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `totalamount` double(10,2) NOT NULL,
  `orderstatus` varchar(30) NOT NULL,
  `deliveraddressid` int(11) NOT NULL,
  `orderdate` date DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderstable`
--

LOCK TABLES `orderstable` WRITE;
/*!40000 ALTER TABLE `orderstable` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productingredienttable`
--

DROP TABLE IF EXISTS `productingredienttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productingredienttable` (
  `productid` int(11) NOT NULL,
  `ingredientid` int(11) NOT NULL,
  `quantity` int(10) DEFAULT NULL,
  PRIMARY KEY (`productid`,`ingredientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productingredienttable`
--

LOCK TABLES `productingredienttable` WRITE;
/*!40000 ALTER TABLE `productingredienttable` DISABLE KEYS */;
/*!40000 ALTER TABLE `productingredienttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productstable`
--

DROP TABLE IF EXISTS `productstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productstable` (
  `productid` int(11) NOT NULL AUTO_INCREMENT,
  `productname` varchar(100) NOT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `productdescription` varchar(500) DEFAULT NULL,
  `productwarnings` varchar(250) DEFAULT NULL,
  `price` double NOT NULL,
  `discount` int(3) DEFAULT NULL,
  `activity` varchar(9) NOT NULL,
  `categoryid` int(11) NOT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productstable`
--

LOCK TABLES `productstable` WRITE;
/*!40000 ALTER TABLE `productstable` DISABLE KEYS */;
INSERT INTO `productstable` VALUES (1,'dougnuts','C:\\Users\\adrian\\Desktop\\cakeshop\\ACOBS\\donuts','its super delicious','may contain nuts',30,0,'active',1);
/*!40000 ALTER TABLE `productstable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userstable`
--

DROP TABLE IF EXISTS `userstable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userstable` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(18) NOT NULL,
  `usertype` varchar(9) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userstable`
--

LOCK TABLES `userstable` WRITE;
/*!40000 ALTER TABLE `userstable` DISABLE KEYS */;
INSERT INTO `userstable` VALUES (1,'keoagile','koitsioekeoagile@gmail.com','hafster','customer','active'),(2,'Themba','thembanator@gmail.com','nator','customer','ACTIVE');
/*!40000 ALTER TABLE `userstable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-11 15:36:40
