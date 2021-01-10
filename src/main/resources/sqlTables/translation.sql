-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Host: 192.168.101.74:3306
-- Generation Time: Nov 14, 2020 at 04:55 PM
-- Server version: 5.7.30-33-log
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kele01_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `source_sphere`
--
DROP TABLE IF EXISTS `translation`;
CREATE TABLE `translation` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `body` text,
  `LAN_EN` text,
  `LAN_DE` text,
  `LAN_FR` text,
  `LAN_ES` text,
  `LAN_IT` text,
  `LAN_PL` text,
  `LAN_KO` text,
  `LAN_US` text,
  `LAN_CN` text,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `source_sphere`
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




