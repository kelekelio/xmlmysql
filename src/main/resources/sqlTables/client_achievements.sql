-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 30, 2021 at 11:30 AM
-- Server version: 8.0.21
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `26158902_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `client_achievements`
--

DROP TABLE IF EXISTS `client_achievements`;
CREATE TABLE IF NOT EXISTS `client_achievements` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` text,
  `description` text,
  `active` int NOT NULL,
  `type` text,
  `repeats` text,
  `race` text,
  `minlevel` int NOT NULL,
  `maxlevel` int NOT NULL,
  `completecount` int NOT NULL,
  `gold` text,
  `exp` text,
  `ap` text,
  `gp` text,
  `item_list` text,
  `action_list` text,
  `completecond` text,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
