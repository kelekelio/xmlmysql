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
DROP TABLE IF EXISTS `source_sphere`;
CREATE TABLE IF NOT EXISTS `source_sphere` (
  `name` varchar(255) NOT NULL DEFAULT '0',
  `type` varchar(255) DEFAULT NULL,
  `zone` varchar(255) NOT NULL DEFAULT '0',
  `layer` int(2) NOT NULL DEFAULT '0',
  `x` decimal(8,4) NOT NULL DEFAULT '0.0000',
  `y` decimal(8,4) NOT NULL DEFAULT '0.0000',
  `z` decimal(8,4) NOT NULL DEFAULT '0.0000',
  `r` decimal(8,4) NOT NULL DEFAULT '0.0000'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `source_sphere`
--
ALTER TABLE `source_sphere`
  ADD PRIMARY KEY (`name`,`zone`,`x`,`y`,`z`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
