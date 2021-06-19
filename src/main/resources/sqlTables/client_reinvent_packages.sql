-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 19, 2021 at 01:33 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kr_live`
--

-- --------------------------------------------------------

--
-- Table structure for table `client_reinvent_packages`
--

DROP TABLE IF EXISTS `client_reinvent_packages`;
CREATE TABLE IF NOT EXISTS `client_reinvent_packages` (
                                                          `id` int NOT NULL,
                                                          `name` varchar(255) NOT NULL,
    `goal_point` int DEFAULT NULL,
    `material_desc` text,
    `renewal_cost` int DEFAULT NULL,
    `renewal_max` int DEFAULT NULL,
    `activate` tinyint(1) DEFAULT NULL,
    `tab_name` text,
    `renewal_increment` int DEFAULT NULL,
    `min_level` int DEFAULT NULL,
    `renewal_item` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `tab_label` text,
    PRIMARY KEY (`id`),
    KEY `name` (`name`),
    KEY `renewal_item` (`renewal_item`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
