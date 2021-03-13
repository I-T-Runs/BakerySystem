
CREATE TABLE `addresstable` (
  `addressid` int(11) NOT NULL AUTO_INCREMENT,
  `housenumber` int(11) NOT NULL,
  `streetname` varchar(100) NOT NULL,
  `suburb` varchar(100) DEFAULT NULL,
  `city` varchar(100) NOT NULL,
  `postcode` int(11) NOT NULL,
  PRIMARY KEY (`addressid`)
) ;


CREATE TABLE `carttable` (
  `cartid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`cartid`)
) ;

CREATE TABLE `categorytable` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(100) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`categoryid`)
) ;
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
);

CREATE TABLE `ingredienttable` (
  `ingredientid` int(11) NOT NULL AUTO_INCREMENT,
  `ingredientname` varchar(100) NOT NULL,
  `quantity` int(10) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`ingredientid`)
) ;

CREATE TABLE `orderdetailstable` (
  `orderdetailsid` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `productprice` double NOT NULL,
  `orderdate` date NOT NULL,
  PRIMARY KEY (`orderdetailsid`)
) ;


CREATE TABLE `orderstable` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `totalamount` double(10,2) NOT NULL,
  `orderstatus` varchar(30) NOT NULL,
  `deliveraddressid` int(11) NOT NULL,
  `orderdate` date DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ;

CREATE TABLE `productingredienttable` (
  `productid` int(11) NOT NULL,
  `ingredientid` int(11) NOT NULL,
  `quantity` int(10) DEFAULT NULL,
  PRIMARY KEY (`productid`,`ingredientid`)
) ;

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
) ;

CREATE TABLE `userstable` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(18) NOT NULL,
  `usertype` varchar(9) NOT NULL,
  `activity` varchar(9) NOT NULL,
  PRIMARY KEY (`userid`)
) ;
