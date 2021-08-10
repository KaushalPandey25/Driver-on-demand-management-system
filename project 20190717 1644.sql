-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.18-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema demand_management_system
--

CREATE DATABASE IF NOT EXISTS demand_management_system;
USE demand_management_system;

--
-- Definition of table `assigndriver`
--

DROP TABLE IF EXISTS `assigndriver`;
CREATE TABLE `assigndriver` (
  `AssignId` int(10) unsigned NOT NULL auto_increment,
  `DriverId` varchar(30) NOT NULL,
  `ClientId` varchar(30) NOT NULL,
  `Date` datetime NOT NULL,
  `Duration` int(10) unsigned NOT NULL,
  `TotalCharges` float NOT NULL,
  PRIMARY KEY  (`AssignId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assigndriver`
--

/*!40000 ALTER TABLE `assigndriver` DISABLE KEYS */;
/*!40000 ALTER TABLE `assigndriver` ENABLE KEYS */;


--
-- Definition of table `clientdetails`
--

DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `ClientId` varchar(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `PhoneNo` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  PRIMARY KEY  (`ClientId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientdetails`
--

/*!40000 ALTER TABLE `clientdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientdetails` ENABLE KEYS */;


--
-- Definition of table `driverdetails`
--

DROP TABLE IF EXISTS `driverdetails`;
CREATE TABLE `driverdetails` (
  `DriverId` varchar(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `PhoneNo` varchar(10) NOT NULL,
  `Age` int(10) unsigned NOT NULL,
  `Gender` varchar(30) NOT NULL,
  `Address` varchar(50) NOT NULL,
  PRIMARY KEY  (`DriverId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driverdetails`
--

/*!40000 ALTER TABLE `driverdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `driverdetails` ENABLE KEYS */;


--
-- Definition of table `feedbackinfo`
--

DROP TABLE IF EXISTS `feedbackinfo`;
CREATE TABLE `feedbackinfo` (
  `Fid` varchar(30) NOT NULL,
  `DriverId` varchar(30) NOT NULL,
  `ClientId` varchar(30) NOT NULL,
  `Date` datetime NOT NULL,
  `Text` varchar(255) NOT NULL,
  PRIMARY KEY  (`Fid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedbackinfo`
--

/*!40000 ALTER TABLE `feedbackinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedbackinfo` ENABLE KEYS */;


--
-- Definition of table `requestdriver`
--

DROP TABLE IF EXISTS `requestdriver`;
CREATE TABLE `requestdriver` (
  `RequestId` int(10) unsigned NOT NULL auto_increment,
  `Date` date NOT NULL,
  `Duration` int(10) unsigned NOT NULL,
  `RequestDate` date NOT NULL,
  `ClientId` varchar(30) NOT NULL,
  PRIMARY KEY  (`RequestId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `requestdriver`
--

/*!40000 ALTER TABLE `requestdriver` DISABLE KEYS */;
/*!40000 ALTER TABLE `requestdriver` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
